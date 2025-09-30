package org.example;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


    public class Customer {
        private final String id;
        private String name;
        private final Set<String> emails = new LinkedHashSet<>();
        private final Set<String> tags = new LinkedHashSet<>();
        private final List<String> notes = new ArrayList<>();

        public Customer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String id() {return id;}
        public String name() { return name;}
        public void setName(String name) {this.name = name;}
        public Set<String> emails() {return emails;}
        public Set<String> tags() {return tags;}
        public List<String> notes() {return notes;}

        public void addEmail(String email) {emails.add(email);}
        public void removeEmail(String email) {emails.remove(email);}
        public void addTag(String tag) {tags.add(tag);}
        public void addNote(String note) {notes.add(note);}

        @Override
        public String toString() {
            return "Customer{id='" + id + "', name='" + name + "', emails=" + emails +
                    ", tags=" + tags + ", notes=" + notes + "}";
        }
    }
