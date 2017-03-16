package com.tainguyenbui.techsprint.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class Merchant {

    @SerializedName("id")
    String id;
    String group_id;
    String created;
    String name;
    String logo;
    String emoji;
    String category;
    Boolean online;
    Boolean atm;
    @SerializedName("address")
    Address address;
    String updated;
    @SerializedName("metadata")
    Metadata metadata;
    Boolean disabled_feedback;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Boolean getAtm() {
        return atm;
    }

    public void setAtm(Boolean atm) {
        this.atm = atm;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Boolean getDisabled_feedback() {
        return disabled_feedback;
    }

    public void setDisabled_feedback(Boolean disabled_feedback) {
        this.disabled_feedback = disabled_feedback;
    }
}
