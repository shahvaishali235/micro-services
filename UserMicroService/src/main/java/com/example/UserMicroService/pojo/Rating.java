package com.example.UserMicroService.pojo;



public class Rating {

    private String ratingId;
    private String userId;
    private int rating;
    private String feedback;

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    @Override
    public String toString() {
        return "Rating{" + "ratingId='" + ratingId + '\'' + ", userId='" + userId + '\'' + ", rating=" + rating + ", feedback='" + feedback + '\'' + '}';
    }
}
