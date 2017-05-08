/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.merval.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author Gonzalo H. Mendoza
 * email: yogonza524@gmail.com
 * StackOverflow: http://stackoverflow.com/users/5079517/gonza
 */
public class RavaData implements Serializable{

    private String species;
    private String last;
    private String percentageDay;
    private String previous;
    private String opening;
    private String min;
    private String max;
    private String hour;
    private String nominalVolume;
    private String effectiveVolume;
    
    private RavaData() {} //Use Builder

    private RavaData(String species, String last, String percentageDay, String previous, String opening, String min, String max, String hour, String nominalVolume, String effectiveVolume) {
        this.species = species;
        this.last = last;
        this.percentageDay = percentageDay;
        this.previous = previous;
        this.opening = opening;
        this.min = min;
        this.max = max;
        this.hour = hour;
        this.nominalVolume = nominalVolume;
        this.effectiveVolume = effectiveVolume;
    }

    public String getEspecie() {
        return species;
    }

    public void setEspecie(String species) {
        this.species = species;
    }

    public String getUltimo() {
        return last;
    }

    public void setUltimo(String last) {
        this.last = last;
    }

    public String getPercentageDay() {
        return percentageDay;
    }

    public void setPercentageDay(String percentageDay) {
        this.percentageDay = percentageDay;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getNominalVolume() {
        return nominalVolume;
    }

    public void setNominalVolume(String nominalVolume) {
        this.nominalVolume = nominalVolume;
    }

    public String getEffectiveVolume() {
        return effectiveVolume;
    }

    public void setEffectiveVolume(String effectiveVolume) {
        this.effectiveVolume = effectiveVolume;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.species);
        hash = 37 * hash + Objects.hashCode(this.last);
        hash = 37 * hash + Objects.hashCode(this.percentageDay);
        hash = 37 * hash + Objects.hashCode(this.previous);
        hash = 37 * hash + Objects.hashCode(this.opening);
        hash = 37 * hash + Objects.hashCode(this.min);
        hash = 37 * hash + Objects.hashCode(this.max);
        hash = 37 * hash + Objects.hashCode(this.hour);
        hash = 37 * hash + Objects.hashCode(this.nominalVolume);
        hash = 37 * hash + Objects.hashCode(this.effectiveVolume);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RavaData other = (RavaData) obj;
        if (!Objects.equals(this.species, other.species)) {
            return false;
        }
        if (!Objects.equals(this.last, other.last)) {
            return false;
        }
        if (!Objects.equals(this.percentageDay, other.percentageDay)) {
            return false;
        }
        if (!Objects.equals(this.previous, other.previous)) {
            return false;
        }
        if (!Objects.equals(this.opening, other.opening)) {
            return false;
        }
        if (!Objects.equals(this.min, other.min)) {
            return false;
        }
        if (!Objects.equals(this.max, other.max)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        if (!Objects.equals(this.nominalVolume, other.nominalVolume)) {
            return false;
        }
        if (!Objects.equals(this.effectiveVolume, other.effectiveVolume)) {
            return false;
        }
        return true;
    }

    
    public static class RavaDataBuilder{
        private String species;
        private String last;
        private String percentageDay;
        private String previous;
        private String opening;
        private String min;
        private String max;
        private String hour;
        private String nominalVolume;
        private String effectiveVolume;

        public RavaDataBuilder() {
        }
        
        public RavaDataBuilder species(String species){
            this.species = species;
            return this;
        }
        
        public RavaDataBuilder last(String last){
            this.last = last;
            return this;
        }
        
        public RavaDataBuilder percentageDay(String percentageDay){
            this.percentageDay = percentageDay;
            return this;
        }
        
        public RavaDataBuilder previous(String previous){
            this.previous = previous;
            return this;
        }
        
        public RavaDataBuilder opening(String opening){
            this.opening = opening;
            return this;
        }
        
        public RavaDataBuilder min(String min){
            this.min = min;
            return this;
        }
        
        public RavaDataBuilder max(String max){
            this.max = max;
            return this;
        }
        
        public RavaDataBuilder hour(String hour){
            this.hour = hour;
            return this;
        }
        
        public RavaDataBuilder nominalVolume(String nominalVolume){
            this.nominalVolume = nominalVolume;
            return this;
        }
        
        public RavaDataBuilder effectiveVolume(String effectiveVolume){
            this.effectiveVolume = effectiveVolume;
            return this;
        }
        
        public RavaData build(){
            RavaData result = new RavaData();
            
            result.effectiveVolume = this.effectiveVolume;
            result.hour = this.hour;
            result.last = this.last;
            result.max = this.max;
            result.min = this.min;
            result.nominalVolume = this.nominalVolume;
            result.opening = this.opening;
            result.percentageDay = this.percentageDay;
            result.previous = this.previous;
            result.species = this.species;
            
            return result;
        }
    }
    
    public String toCSV(){
        String separator = ",";
        String delimiter = "|";
//        String carriage = "\n";
        
        StringBuilder builder = new StringBuilder();
        
        builder.append(species)
                .append(separator)
                .append(last)
                .append(separator)
                .append(percentageDay)
                .append(separator)
                .append(previous)
                .append(separator)
                .append(opening)
                .append(separator)
                .append(min)
                .append(separator)
                .append(max)
                .append(separator)
                .append(hour)
                .append(separator)
                .append(nominalVolume)
                .append(separator)
                .append(effectiveVolume)
                .append(delimiter);
//                .append(carriage);
        
        return builder.toString();
    }
}
