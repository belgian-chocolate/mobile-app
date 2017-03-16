package com.tainguyenbui.techsprint.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class Metadata {

    String created_for_merchant;
    String created_for_transaction;
    String foursquare_category;
    String foursquare_category_icon;
    String foursquare_id;
    String foursquare_website;
    String google_places_icon;
    String google_places_id;
    String google_places_name;
    @SerializedName("suggested_name")
    String suggested_name;
    String suggested_tags;
    String twitter_id;
    String website;

    public String getCreated_for_merchant() {
        return created_for_merchant;
    }

    public void setCreated_for_merchant(String created_for_merchant) {
        this.created_for_merchant = created_for_merchant;
    }

    public String getCreated_for_transaction() {
        return created_for_transaction;
    }

    public void setCreated_for_transaction(String created_for_transaction) {
        this.created_for_transaction = created_for_transaction;
    }

    public String getFoursquare_category() {
        return foursquare_category;
    }

    public void setFoursquare_category(String foursquare_category) {
        this.foursquare_category = foursquare_category;
    }

    public String getFoursquare_category_icon() {
        return foursquare_category_icon;
    }

    public void setFoursquare_category_icon(String foursquare_category_icon) {
        this.foursquare_category_icon = foursquare_category_icon;
    }

    public String getFoursquare_id() {
        return foursquare_id;
    }

    public void setFoursquare_id(String foursquare_id) {
        this.foursquare_id = foursquare_id;
    }

    public String getFoursquare_website() {
        return foursquare_website;
    }

    public void setFoursquare_website(String foursquare_website) {
        this.foursquare_website = foursquare_website;
    }

    public String getGoogle_places_icon() {
        return google_places_icon;
    }

    public void setGoogle_places_icon(String google_places_icon) {
        this.google_places_icon = google_places_icon;
    }

    public String getGoogle_places_id() {
        return google_places_id;
    }

    public void setGoogle_places_id(String google_places_id) {
        this.google_places_id = google_places_id;
    }

    public String getGoogle_places_name() {
        return google_places_name;
    }

    public void setGoogle_places_name(String google_places_name) {
        this.google_places_name = google_places_name;
    }

    public String getSuggested_name() {
        return suggested_name;
    }

    public void setSuggested_name(String suggested_name) {
        this.suggested_name = suggested_name;
    }

    public String getSuggested_tags() {
        return suggested_tags;
    }

    public void setSuggested_tags(String suggested_tags) {
        this.suggested_tags = suggested_tags;
    }

    public String getTwitter_id() {
        return twitter_id;
    }

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
