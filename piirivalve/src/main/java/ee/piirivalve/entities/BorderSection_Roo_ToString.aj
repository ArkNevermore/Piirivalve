// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.piirivalve.entities;

import java.lang.String;

privileged aspect BorderSection_Roo_ToString {
    
    public String BorderSection.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ").append(getCode()).append(", ");
        sb.append("Comment: ").append(getComment()).append(", ");
        sb.append("Coordinates: ").append(getCoordinates()).append(", ");
        sb.append("Created: ").append(getCreated()).append(", ");
        sb.append("Creator: ").append(getCreator()).append(", ");
        sb.append("CrossingPoint: ").append(getCrossingPoint() == null ? "null" : getCrossingPoint().size()).append(", ");
        sb.append("Deleted: ").append(getDeleted()).append(", ");
        sb.append("Deleter: ").append(getDeleter()).append(", ");
        sb.append("Enddate: ").append(getEnddate()).append(", ");
        sb.append("Guard: ").append(getGuard() == null ? "null" : getGuard().size()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Modified: ").append(getModified()).append(", ");
        sb.append("Modifier: ").append(getModifier()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Startdate: ").append(getStartdate()).append(", ");
        sb.append("Troops: ").append(getTroops());
        return sb.toString();
    }
    
}
