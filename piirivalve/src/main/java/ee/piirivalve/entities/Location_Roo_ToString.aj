// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import java.lang.String;

privileged aspect Location_Roo_ToString {
    
    public String Location.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Created: ").append(getCreated()).append(", ");
        sb.append("Creator: ").append(getCreator()).append(", ");
        sb.append("Deleted: ").append(getDeleted()).append(", ");
        sb.append("Deleter: ").append(getDeleter()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Modified: ").append(getModified()).append(", ");
        sb.append("Modifier: ").append(getModifier()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Troops: ").append(getTroops() == null ? "null" : getTroops().size()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
