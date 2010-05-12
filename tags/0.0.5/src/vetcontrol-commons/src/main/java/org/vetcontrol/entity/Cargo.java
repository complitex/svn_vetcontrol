package org.vetcontrol.entity;

import javax.xml.bind.annotation.*;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 12.01.2010 15:11:00
 *
 * Сущность объектно-реляционного отображения груза
 */
@Entity
@Table(name = "cargo")
@IdClass(ClientEntityId.class)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cargo extends Synchronized implements IUpdated, IQuery{
    @Id
//    @TableGenerator(name = "cargo", table = "generator", pkColumnName = "generatorName",
//            valueColumnName = "generatorValue", allocationSize = 1, initialValue = 100,
//            uniqueConstraints = @UniqueConstraint(columnNames = {"id", "client_id", "department_id"}))
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cargo")
    @GeneratedValue(generator = "EnhancedTableGenerator")
    @GenericGenerator(name = "EnhancedTableGenerator", strategy = "org.vetcontrol.hibernate.id.TableFallbackToAssignedGenerator",
    parameters = {
        @Parameter(name = "segment_value", value = "cargo"),
        @Parameter(name = "table_name", value = "generator"),
        @Parameter(name = "segment_column_name", value = "generatorName"),
        @Parameter(name = "value_column_name", value = "generatorValue"),
        @Parameter(name = "initial_value", value = "100"),
        @Parameter(name = "increment_size", value = "1"),
        @Parameter(name = "property", value = "id")})
    @Column(nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "cargo_type_id", nullable = false)
    @XmlIDREF
    private CargoType cargoType;

    @ManyToOne
    @JoinColumn(name = "unit_type_id", nullable = true)
    @XmlIDREF
    private UnitType unitType;

    @Column(name = "count", nullable = true, precision = 2)
    private Double count;

    @Column(name = "certificate_details", length = 255, nullable = false)
    private String certificateDetails;

    @Temporal(TemporalType.DATE)
    @Column(name = "certificate_date", nullable = false)
    private Date certificateDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @ManyToOne
    @JoinColumn(name = "cargo_producer_id", nullable = false)
    @XmlIDREF
    private CargoProducer cargoProducer;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="vehicle_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name="department_id", referencedColumnName = "department_id", insertable = false, updatable = false),
        @JoinColumn(name="client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    })
    @XmlIDREF
    private Vehicle vehicle;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @PrePersist @PreUpdate
    protected void preUpdate(){
        if (documentCargo != null){
            documentCargoId = documentCargo.getId();
            vehicleId = vehicle != null ? vehicle.getId() : null;
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


    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getCertificateDetails() {
        return certificateDetails;
    }

    public void setCertificateDetails(String certificateDetails) {
        this.certificateDetails = certificateDetails;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Override
    public Date getUpdated() {
        return updated;
    }

    @Override
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public CargoProducer getCargoProducer() {
        return cargoProducer;
    }

    public void setCargoProducer(CargoProducer cargoProducer) {
        this.cargoProducer = cargoProducer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargo)) return false;
        if (!super.equals(o)) return false;

        Cargo cargo = (Cargo) o;

        if (cargoProducer != null ? !cargoProducer.equals(cargo.cargoProducer) : cargo.cargoProducer != null)
            return false;
        if (cargoType != null ? !cargoType.equals(cargo.cargoType) : cargo.cargoType != null) return false;
        if (certificateDate != null ? !certificateDate.equals(cargo.certificateDate) : cargo.certificateDate != null)
            return false;
        if (certificateDetails != null ? !certificateDetails.equals(cargo.certificateDetails) : cargo.certificateDetails != null)
            return false;
        if (client != null ? !client.equals(cargo.client) : cargo.client != null) return false;
        if (count != null ? !count.equals(cargo.count) : cargo.count != null) return false;
        if (department != null ? !department.equals(cargo.department) : cargo.department != null) return false;
        if (documentCargo != null ? !documentCargo.equals(cargo.documentCargo) : cargo.documentCargo != null)
            return false;
        if (documentCargoId != null ? !documentCargoId.equals(cargo.documentCargoId) : cargo.documentCargoId != null)
            return false;
        if (id != null ? !id.equals(cargo.id) : cargo.id != null) return false;
        if (unitType != null ? !unitType.equals(cargo.unitType) : cargo.unitType != null) return false;
        if (updated != null ? !updated.equals(cargo.updated) : cargo.updated != null) return false;
        if (vehicle != null ? !vehicle.equals(cargo.vehicle) : cargo.vehicle != null) return false;
        if (vehicleId != null ? !vehicleId.equals(cargo.vehicleId) : cargo.vehicleId != null) return false;

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
        result = 31 * result + (cargoType != null ? cargoType.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (certificateDetails != null ? certificateDetails.hashCode() : 0);
        result = 31 * result + (certificateDate != null ? certificateDate.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (cargoProducer != null ? cargoProducer.hashCode() : 0);
        result = 31 * result + (vehicle != null ? vehicle.hashCode() : 0);
        result = 31 * result + (vehicleId != null ? vehicleId.hashCode() : 0);
        return result;
    }

    @Override
    public Query getInsertQuery(EntityManager em) {
        return em.createNativeQuery("insert into cargo (id, client_id, department_id, document_cargo_id, cargo_type_id, " +
                "unit_type_id, `count`, certificate_details, certificate_date, updated, cargo_producer_id, vehicle_id, " +
                "sync_status) " +
                "value (:id, :client_id, :department_id, :document_cargo_id, :cargo_type_id, :unit_type_id, :count, " +
                ":certificate_details, :certificate_date, :updated, :cargo_producer_id, :vehicle_id, :sync_status)")
                .setParameter("id", id)
                .setParameter("client_id", client != null ? client.getId() : null)
                .setParameter("department_id", department != null ? department.getId() : null)
                .setParameter("document_cargo_id", documentCargoId)
                .setParameter("cargo_type_id", cargoType != null ? cargoType.getId() : null)
                .setParameter("unit_type_id", unitType != null ? unitType.getId() : null)
                .setParameter("count", count)
                .setParameter("certificate_details", certificateDetails)
                .setParameter("certificate_date", certificateDate)
                .setParameter("updated", updated)
                .setParameter("cargo_producer_id", cargoProducer != null ? cargoProducer.getId() : null)
                .setParameter("vehicle_id", vehicleId)
                .setParameter("sync_status", syncStatus != null ? syncStatus.name() : null);
    }

    @Override
    public Query getUpdateQuery(EntityManager em) {
        return null;
    }
}

