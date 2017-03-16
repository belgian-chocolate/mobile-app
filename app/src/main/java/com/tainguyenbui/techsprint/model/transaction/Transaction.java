package com.tainguyenbui.techsprint.model.transaction;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class Transaction {

    @SerializedName("id")
    private String id;
    @SerializedName("created")
    private String created;
    @SerializedName("description")
    private String description;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("currency")
    private String currency;
    @SerializedName("merchant")
    private Merchant merchant;
    private String notes;
    private String account_balance;
    @SerializedName("category")
    private String category;
    private Boolean is_load;
    private String settled;
    private BigDecimal local_amount;
    private String local_currency;
    private String updated;
    private String account_id;
    private String scheme;
    private String dedupe_id;
    private Boolean originator;
    private Boolean include_in_spending;
    @SerializedName("name")
    private String name;
    @SerializedName("logo")
    private String logo;
    @SerializedName("suggested_name")
    private String suggested_name;
    @SerializedName("foursquare_category_icon")
    private String foursquare_category_icon;

    public Transaction(String id, String created, String description, BigDecimal amount, String currency, Merchant merchant, String notes, String account_balance, String category, Boolean is_load, String settled, BigDecimal local_amount, String local_currency, String updated, String account_id, String scheme, String dedupe_id, Boolean originator, Boolean include_in_spending) {
        this.id = id;
        this.created = created;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.merchant = merchant;
        this.notes = notes;
        this.account_balance = account_balance;
        this.category = category;
        this.is_load = is_load;
        this.settled = settled;
        this.local_amount = local_amount;
        this.local_currency = local_currency;
        this.updated = updated;
        this.account_id = account_id;
        this.scheme = scheme;
        this.dedupe_id = dedupe_id;
        this.originator = originator;
        this.include_in_spending = include_in_spending;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIs_load() {
        return is_load;
    }

    public void setIs_load(Boolean is_load) {
        this.is_load = is_load;
    }

    public String getSettled() {
        return settled;
    }

    public void setSettled(String settled) {
        this.settled = settled;
    }

    public BigDecimal getLocal_amount() {
        return local_amount;
    }

    public void setLocal_amount(BigDecimal local_amount) {
        this.local_amount = local_amount;
    }

    public String getLocal_currency() {
        return local_currency;
    }

    public void setLocal_currency(String local_currency) {
        this.local_currency = local_currency;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getDedupe_id() {
        return dedupe_id;
    }

    public void setDedupe_id(String dedupe_id) {
        this.dedupe_id = dedupe_id;
    }

    public Boolean getOriginator() {
        return originator;
    }

    public void setOriginator(Boolean originator) {
        this.originator = originator;
    }

    public Boolean getInclude_in_spending() {
        return include_in_spending;
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

    public String getSuggested_name() {
        return suggested_name;
    }

    public void setSuggested_name(String suggested_name) {
        this.suggested_name = suggested_name;
    }

    public String getFoursquare_category_icon() {
        return foursquare_category_icon;
    }

    public void setFoursquare_category_icon(String foursquare_category_icon) {
        this.foursquare_category_icon = foursquare_category_icon;
    }

    public void setInclude_in_spending(Boolean include_in_spending) {
        this.include_in_spending = include_in_spending;
    }
}
