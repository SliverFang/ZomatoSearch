package com.example.zomatosearch.data.network.models;
/*
 *Restaurant Class in Zomato JSON Response, used to store serialised restaurant information from
 * JSON data.
 */
import java.util.ArrayList;

public class Restaurant {
    private String id;
    private String name;
    private String url;
    private Location location;
    private String cuisines;
    private String timings;
    private String average_cost_for_two;
    private String price_range;
    private String currency;
    private ArrayList<String> highlights;
    private int opentable_support;
    private int is_zomato_book_res;
    private String mezzo_provider;
    private int is_book_form_web_view;
    private String book_form_web_view_url;
    private String book_again_url;
    private String thumb;
    private UserRating user_rating;
    private int all_reviews_count;
    private String photos_url;
    private int photo_count;
    private String menu_url;
    private String featured_image;
    private int has_online_delivery;
    private int is_delivering_now;
    private String store_type;
    private Boolean include_bogo_offers;
    private String deeplink;
    private int is_table_reservation_supported;
    private int has_table_booking;
    private String events_url;
    private String phone_numbers;

    public Restaurant(String id, String name, String url, Location location, String cuisines, String timings, String average_cost_for_two, String price_range, String currency, ArrayList<String> highlights, int opentable_support, int is_zomato_book_res, String mezzo_provider, int is_book_form_web_view, String book_form_web_view_url, String book_again_url, String thumb, UserRating user_rating, int all_reviews_count, String photos_url, int photo_count, String menu_url, String featured_image, int has_online_delivery, int is_delivering_now, String store_type, Boolean include_bogo_offers, String deeplink, int is_table_reservation_supported, int has_table_booking, String events_url, String phone_numbers) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.cuisines = cuisines;
        this.timings = timings;
        this.average_cost_for_two = average_cost_for_two;
        this.price_range = price_range;
        this.currency = currency;
        this.highlights = highlights;
        this.opentable_support = opentable_support;
        this.is_zomato_book_res = is_zomato_book_res;
        this.mezzo_provider = mezzo_provider;
        this.is_book_form_web_view = is_book_form_web_view;
        this.book_form_web_view_url = book_form_web_view_url;
        this.book_again_url = book_again_url;
        this.thumb = thumb;
        this.user_rating = user_rating;
        this.all_reviews_count = all_reviews_count;
        this.photos_url = photos_url;
        this.photo_count = photo_count;
        this.menu_url = menu_url;
        this.featured_image = featured_image;
        this.has_online_delivery = has_online_delivery;
        this.is_delivering_now = is_delivering_now;
        this.store_type = store_type;
        this.include_bogo_offers = include_bogo_offers;
        this.deeplink = deeplink;
        this.is_table_reservation_supported = is_table_reservation_supported;
        this.has_table_booking = has_table_booking;
        this.events_url = events_url;
        this.phone_numbers = phone_numbers;
    }

    public Restaurant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(String average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ArrayList<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(ArrayList<String> highlights) {
        this.highlights = highlights;
    }

    public int getOpentable_support() {
        return opentable_support;
    }

    public void setOpentable_support(int opentable_support) {
        this.opentable_support = opentable_support;
    }

    public int getIs_zomato_book_res() {
        return is_zomato_book_res;
    }

    public void setIs_zomato_book_res(int is_zomato_book_res) {
        this.is_zomato_book_res = is_zomato_book_res;
    }

    public String getMezzo_provider() {
        return mezzo_provider;
    }

    public void setMezzo_provider(String mezzo_provider) {
        this.mezzo_provider = mezzo_provider;
    }

    public int getIs_book_form_web_view() {
        return is_book_form_web_view;
    }

    public void setIs_book_form_web_view(int is_book_form_web_view) {
        this.is_book_form_web_view = is_book_form_web_view;
    }

    public String getBook_form_web_view_url() {
        return book_form_web_view_url;
    }

    public void setBook_form_web_view_url(String book_form_web_view_url) {
        this.book_form_web_view_url = book_form_web_view_url;
    }

    public String getBook_again_url() {
        return book_again_url;
    }

    public void setBook_again_url(String book_again_url) {
        this.book_again_url = book_again_url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRating user_rating) {
        this.user_rating = user_rating;
    }

    public int getAll_reviews_count() {
        return all_reviews_count;
    }

    public void setAll_reviews_count(int all_reviews_count) {
        this.all_reviews_count = all_reviews_count;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public int getPhoto_count() {
        return photo_count;
    }

    public void setPhoto_count(int photo_count) {
        this.photo_count = photo_count;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public int getHas_online_delivery() {
        return has_online_delivery;
    }

    public void setHas_online_delivery(int has_online_delivery) {
        this.has_online_delivery = has_online_delivery;
    }

    public int getIs_delivering_now() {
        return is_delivering_now;
    }

    public void setIs_delivering_now(int is_delivering_now) {
        this.is_delivering_now = is_delivering_now;
    }

    public String getStore_type() {
        return store_type;
    }

    public void setStore_type(String store_type) {
        this.store_type = store_type;
    }

    public Boolean getInclude_bogo_offers() {
        return include_bogo_offers;
    }

    public void setInclude_bogo_offers(Boolean include_bogo_offers) {
        this.include_bogo_offers = include_bogo_offers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public int getIs_table_reservation_supported() {
        return is_table_reservation_supported;
    }

    public void setIs_table_reservation_supported(int is_table_reservation_supported) {
        this.is_table_reservation_supported = is_table_reservation_supported;
    }

    public int getHas_table_booking() {
        return has_table_booking;
    }

    public void setHas_table_booking(int has_table_booking) {
        this.has_table_booking = has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", location=" + location +
                ", cuisines=" + cuisines +
                ", timings='" + timings + '\'' +
                ", average_cost_for_two='" + average_cost_for_two + '\'' +
                ", price_range='" + price_range + '\'' +
                ", currency='" + currency + '\'' +
                ", highlights=" + highlights +
                ", opentable_support=" + opentable_support +
                ", is_zomato_book_res=" + is_zomato_book_res +
                ", mezzo_provider='" + mezzo_provider + '\'' +
                ", is_book_form_web_view=" + is_book_form_web_view +
                ", book_form_web_view_url='" + book_form_web_view_url + '\'' +
                ", book_again_url='" + book_again_url + '\'' +
                ", thumb='" + thumb + '\'' +
                ", user_rating=" + user_rating +
                ", all_reviews_count=" + all_reviews_count +
                ", photos_url='" + photos_url + '\'' +
                ", photo_count=" + photo_count +
                ", menu_url='" + menu_url + '\'' +
                ", featured_image='" + featured_image + '\'' +
                ", has_online_delivery=" + has_online_delivery +
                ", is_delivering_now=" + is_delivering_now +
                ", store_type='" + store_type + '\'' +
                ", include_bogo_offers=" + include_bogo_offers +
                ", deeplink='" + deeplink + '\'' +
                ", is_table_reservation_supported=" + is_table_reservation_supported +
                ", has_table_booking=" + has_table_booking +
                ", events_url='" + events_url + '\'' +
                ", phone_numbers='" + phone_numbers + '\'' +
                '}';
    }
}
