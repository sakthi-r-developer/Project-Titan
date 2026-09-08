package com.cyberinvestigator;

import com.cyberinvestigator.model.Event;
import com.cyberinvestigator.parser.JsonParser;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("        CYBER INVESTIGATION ASSISTANT");
        System.out.println("============================================================");

        String evidenceFile = "../data/demo_incident.json";

        try {
            JsonParser parser = new JsonParser();

            List<Event> events = parser.loadEvents(evidenceFile);

            System.out.println();
            System.out.println("Evidence loaded successfully.");
            System.out.println("Events loaded: " + events.size());

            System.out.println();
            System.out.println("EVENTS");
            System.out.println("------------------------------------------------------------");

            for (Event event : events) {
                System.out.println(event);
            }

            System.out.println();
            System.out.println("============================================================");
            System.out.println("PHASE 1 COMPLETE");
            System.out.println("Evidence ingestion is working.");
            System.out.println("============================================================");

        } catch (Exception e) {

            System.out.println();
            System.out.println("ERROR");
            System.out.println("------------------------------------------------------------");
            System.out.println(e.getMessage());

            e.printStackTrace();
        }
    }
}