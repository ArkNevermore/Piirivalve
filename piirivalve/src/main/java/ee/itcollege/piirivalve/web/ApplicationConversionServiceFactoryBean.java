package ee.itcollege.piirivalve.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

import ee.piirivalve.entities.BorderGuard;
import ee.piirivalve.entities.BorderSection;
import ee.piirivalve.entities.CrossingPoint;
import ee.piirivalve.entities.Guard;
import ee.piirivalve.entities.Location;
import ee.piirivalve.entities.Troops;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {
	
   public void installLabelConverters(FormatterRegistry registry) {
		registry.addConverter(new LocationConverter());
		registry.addConverter(new TroopsConverter());
		registry.addConverter(new BorderSectionConverter());
		registry.addConverter(new CrossingPointConverter());
		registry.addConverter(new GuardConverter());
		registry.addConverter(new BorderGuardConverter());
    }
   
   public void afterPropertiesSet() {
       super.afterPropertiesSet();
       installLabelConverters(getObject());
   }

    static class LocationConverter implements Converter<Location, String> {
        public String convert(Location location) {
            return location.getName().toString();
        }
        
    }
    
    static class TroopsConverter implements Converter<Troops, String> {
        public String convert(Troops troops) {
            return troops.getCode().toString();
        }
        
    }
    
    static class BorderSectionConverter implements Converter<BorderSection, String> {
        public String convert(BorderSection borderSection) {
            return borderSection.getName().toString();
        }
        
    }
    
    static class CrossingPointConverter implements Converter<CrossingPoint, String> {
        public String convert(CrossingPoint crossingPoint) {
            return crossingPoint.getName().toString();
        }
        
    }
    
    static class GuardConverter implements Converter<Guard, String> {
        public String convert(Guard guard) {
            return guard.getName().toString();
        }
        
    }
    
    static class BorderGuardConverter implements Converter<BorderGuard, String> {
        public String convert(BorderGuard borderGuard) {
            return borderGuard.getName().toString();
        }
        
    }

    
}