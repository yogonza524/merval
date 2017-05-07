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
    private double last;
    private double percentageDay;
    private double previous;
    private double opening;
    private double min;
    private double max;
    private String hour;
    private int nominalVolume;
    private int effectiveVolume;
    
    private RavaData() {} //Use Builder

    private RavaData(String species, double last, double percentageDay, double previous, double opening, double min, double max, String hour, int nominalVolume, int effectiveVolume) {
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

    public double getUltimo() {
        return last;
    }

    public void setUltimo(double last) {
        this.last = last;
    }

    public double getPercentageDay() {
        return percentageDay;
    }

    public void setPercentageDay(double percentageDay) {
        this.percentageDay = percentageDay;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    public double getOpening() {
        return opening;
    }

    public void setOpening(double opening) {
        this.opening = opening;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getNominalVolume() {
        return nominalVolume;
    }

    public void setNominalVolume(int nominalVolume) {
        this.nominalVolume = nominalVolume;
    }

    public int getEffectiveVolume() {
        return effectiveVolume;
    }

    public void setEffectiveVolume(int effectiveVolume) {
        this.effectiveVolume = effectiveVolume;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.species);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.last) ^ (Double.doubleToLongBits(this.last) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.percentageDay) ^ (Double.doubleToLongBits(this.percentageDay) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.previous) ^ (Double.doubleToLongBits(this.previous) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.opening) ^ (Double.doubleToLongBits(this.opening) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.min) ^ (Double.doubleToLongBits(this.min) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.max) ^ (Double.doubleToLongBits(this.max) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.hour);
        hash = 79 * hash + this.nominalVolume;
        hash = 79 * hash + this.effectiveVolume;
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
        if (Double.doubleToLongBits(this.last) != Double.doubleToLongBits(other.last)) {
            return false;
        }
        if (Double.doubleToLongBits(this.percentageDay) != Double.doubleToLongBits(other.percentageDay)) {
            return false;
        }
        if (Double.doubleToLongBits(this.previous) != Double.doubleToLongBits(other.previous)) {
            return false;
        }
        if (Double.doubleToLongBits(this.opening) != Double.doubleToLongBits(other.opening)) {
            return false;
        }
        if (Double.doubleToLongBits(this.min) != Double.doubleToLongBits(other.min)) {
            return false;
        }
        if (Double.doubleToLongBits(this.max) != Double.doubleToLongBits(other.max)) {
            return false;
        }
        if (this.nominalVolume != other.nominalVolume) {
            return false;
        }
        if (this.effectiveVolume != other.effectiveVolume) {
            return false;
        }
        if (!Objects.equals(this.species, other.species)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        return true;
    }

    public static class RavaDataBuilder{
        private String species;
        private double last;
        private double percentageDay;
        private double previous;
        private double opening;
        private double min;
        private double max;
        private String hour;
        private int nominalVolume;
        private int effectiveVolume;

        public RavaDataBuilder() {
        }
        
        public RavaDataBuilder species(String species){
            this.species = species;
            return this;
        }
        
        public RavaDataBuilder last(double last){
            this.last = last;
            return this;
        }
        
        public RavaDataBuilder percentageDay(double percentageDay){
            this.percentageDay = percentageDay;
            return this;
        }
        
        public RavaDataBuilder previous(double previous){
            this.previous = previous;
            return this;
        }
        
        public RavaDataBuilder opening(double opening){
            this.opening = opening;
            return this;
        }
        
        public RavaDataBuilder min(double min){
            this.min = min;
            return this;
        }
        
        public RavaDataBuilder max(double max){
            this.max = max;
            return this;
        }
        
        public RavaDataBuilder hour(String hour){
            this.hour = hour;
            return this;
        }
        
        public RavaDataBuilder nominalVolume(int nominalVolume){
            this.nominalVolume = nominalVolume;
            return this;
        }
        
        public RavaDataBuilder effectiveVolume(int effectiveVolume){
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
        String carriage = "\n";
        
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
