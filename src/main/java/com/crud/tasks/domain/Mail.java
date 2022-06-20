package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Mail {
    private final String mailTo;
    private final String subject;
    private final String message;
    private final String toCc;

    public static class Builder {
        private String mailTo;
        private String subject;
        private String message;
        private String toCc;

        public Builder mailTo(String mailTo) {
            this.mailTo = mailTo;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder toCc(String toCc) {
            this.toCc = toCc;
            return this;
        }

        public Mail build() {
            return new Mail(mailTo, subject, message, toCc);
        }
    }
}