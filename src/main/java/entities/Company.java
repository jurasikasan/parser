package entities;

import java.util.*;

/**
 *
 * @author FOX
 */
public class Company {

    public String name="ERROR";
    public String viewLink;
    public Set<String> sites = new LinkedHashSet<>();
    public String googleSearch;
    public boolean attention;
    
    public String getFormattedSites(){
        String sitesF ="";
        
        for(String site: sites){
            sitesF+=site+" ";
        }
        return sitesF;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.viewLink);
        hash = 31 * hash + Objects.hashCode(this.sites);
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
        final Company other = (Company) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.viewLink, other.viewLink)) {
            return false;
        }
//        if (!Objects.equals(this.sites, other.sites)) {
//            return false;
//        }
        return true;
    }

}
