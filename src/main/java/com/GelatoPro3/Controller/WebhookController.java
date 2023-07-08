package com.GelatoPro3.Controller;

import com.GelatoPro3.Service.MailService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/api/webhook")
public class WebhookController {

    // Replace with your webhook signing secret
    public static final String WEBHOOK_SECRET = "whsec_JLaj1AfISpYTi5EWgST2iRYyeomCdJoY";

    @Autowired
    MailService mailService;

    @PostMapping("/payment")//stripe payment
    public ResponseEntity<String> handleWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
        try {
            System.out.println("Payload: " + payload);
            System.out.println("sigHeader: " + sigHeader);
            // Verify the webhook signature
            Event event = Webhook.constructEvent(payload, sigHeader, WEBHOOK_SECRET);

            // Parse the string into a JSON object
            JSONObject jsonObj = new JSONObject(payload);

            String userId = jsonObj.getString("id");
            System.out.println("userId: " + userId);

            String customer_email = jsonObj.getJSONObject("data").getJSONObject("metadata").getString("customer_email");
            System.out.println("customer: " + customer_email);

            // Handle the event
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    mailService.sendMail();
                    break;
                case "payment_method.attached":
                    // Do something with the payment method
                    break;
                default:
                    // Unexpected event type
                    return ResponseEntity.badRequest().body("Unhandled event type: " + event.getType());
            }

            // Return a 200 response to acknowledge receipt of the event
            return ResponseEntity.ok().body("Received event: " + event.getId());

        } catch (SignatureVerificationException e) {
            // Invalid signature
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid webhook signature");
        } catch (Exception e) {
            // Something else went wrong
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}