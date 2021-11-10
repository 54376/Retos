package com.usa.ciclo3.reto3.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ReportsStatus {
        private int completed;
        private int cancelled;
        public ReportsStatus(int completed, int cancelled) {
            super();
            this.completed = completed;
            this.cancelled = cancelled;
        }
        public int getCompleted() {
            return completed;
        }
        public void setCompleted(int completed) {
            this.completed = completed;
        }
        public int getCancelled() {
            return cancelled;
        }
        public void setCancelled(int cancelled) {
            this.cancelled = cancelled;
        }
    }
}