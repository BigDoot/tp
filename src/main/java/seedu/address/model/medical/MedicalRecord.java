package seedu.address.model.medical;

import static seedu.address.model.medical.DateFormat.DATE_FORMAT_DISPLAY;
import static seedu.address.model.medical.DateFormat.DATE_FORMAT_STORAGE;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import seedu.address.model.person.Person;

/**
 * Represents a Appointment of a Patient.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class MedicalRecord {
    // attributes from appointment
    private Person person;
    private LocalDateTime date;
    private String zoomMeetingUrl;

    // related to the medical record
    List<Section> sections;

    /**
     * Every field must be present and not null.
     */
    public MedicalRecord(Person person, LocalDateTime date, List<String> sections) {
        this.person = person;
        this.date = date;
        this.sections = new ArrayList<>();
        for (String section : sections){
            this.sections.add(new Section(section));
        }
    }

//TODO REMOVE PERSON FROM MEDICAL RECORD
    /**
     * Every field must be present and not null.
     */
    public MedicalRecord(LocalDateTime date, List<Section> sections) {
        this.date = date;
        this.sections = sections;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getZoomMeetingUrl() {
        return zoomMeetingUrl;
    }

    // create medical record from appointment
    public MedicalRecord(Appointment appointment, List<String> sections) {
        this.person = appointment.getPerson();
        this.date = appointment.getDate();
        this.zoomMeetingUrl = appointment.getZoomMeetingUrl();
        this.sections = new ArrayList<>();
        for (String section : sections){
            this.sections.add(new Section(section));
        }
    }

    // for storage into JSON
    public String getDateStorage() {
        return date.format(DATE_FORMAT_STORAGE);
    }

    // for displaying, doesnt have year
    public String getDateDisplay() {
        return date.format(DATE_FORMAT_DISPLAY);
    }

    public List<Section> getSections() { return Collections.unmodifiableList(sections); }
}
