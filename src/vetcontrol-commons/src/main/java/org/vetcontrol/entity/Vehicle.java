/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vetcontrol.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.vetcontrol.sync.adapter.LongAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 *
 * @author Artem
 */
@Entity
@Table(name = "vehicle")
@IdClass(ClientEntityId.class)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle extends Synchronized implements IUpdated {

    @Id
    @GeneratedValue(generator = "EnhancedTableGenerator")
    @GenericGenerator(name = "EnhancedTableGenerator", strategy = "org.vetcontrol.hibernate.id.TableGenerator",
    parameters = {
        @Parameter(name = "segment_value", value = "vehicle"),
        @Parameter(name = "table_name", value = "generator"),
        @Parameter(name = "segment_column_name", value = "generatorName"),
        @Parameter(name = "value_column_name", value = "generatorValue"),
        @Parameter(name = "initial_value", value = "100"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "property", value = "id")})
    @XmlID
    @XmlJavaTypeAdapter(LongAdapter.class)
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @XmlIDREF
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @XmlIDREF
    private Department department;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "document_cargo_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = false, updatable = false),
        @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)})
    @XmlTransient
    private DocumentCargo documentCargo;

    @Column(name = "document_cargo_id")
    private Long documentCargoId;

    @Column(name = "vehicle_details", length = 255, nullable = false)
    private String vehicleDetails;

    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @Transient
    @XmlTransient
    private String name = "";

    @PrePersist
    @PreUpdate
    protected void preUpdate() {
        if (documentCargo != null) {
            documentCargoId = documentCargo.getId();
            client = documentCargo.getClient();
            department = documentCargo.getDepartment();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DocumentCargo getDocumentCargo() {
        return documentCargo;
    }

    public void setDocumentCargo(DocumentCargo documentCargo) {
        this.documentCargo = documentCargo;
    }

    public Long getDocumentCargoId() {
        return documentCargoId;
    }

    public void setDocumentCargoId(Long documentCargoId) {
        this.documentCargoId = documentCargoId;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        if (!super.equals(o)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (client != null ? !client.equals(vehicle.client) : vehicle.client != null) return false;
        if (department != null ? !department.equals(vehicle.department) : vehicle.department != null) return false;
        if (documentCargo != null ? !documentCargo.equals(vehicle.documentCargo) : vehicle.documentCargo != null) return false;
        if (documentCargoId != null ? !documentCargoId.equals(vehicle.documentCargoId) : vehicle.documentCargoId != null) return false;
        if (id != null ? !id.equals(vehicle.id) : vehicle.id != null) return false;
        if (name != null ? !name.equals(vehicle.name) : vehicle.name != null) return false;
        if (updated != null ? !updated.equals(vehicle.updated) : vehicle.updated != null) return false;
        if (vehicleDetails != null ? !vehicleDetails.equals(vehicle.vehicleDetails) : vehicle.vehicleDetails != null) return false;
        if (vehicleType != vehicle.vehicleType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (documentCargo != null ? documentCargo.hashCode() : 0);
        result = 31 * result + (documentCargoId != null ? documentCargoId.hashCode() : 0);
        result = 31 * result + (vehicleDetails != null ? vehicleDetails.hashCode() : 0);
        result = 31 * result + (vehicleType != null ? vehicleType.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
