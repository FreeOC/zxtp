package com.baizhi.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer vuUserId;

    private String vuUserName;

    private String vuPassword;

    private Integer vuStatus;

    private static final long serialVersionUID = 1L;

    public Integer getVuUserId() {
        return vuUserId;
    }

    public void setVuUserId(Integer vuUserId) {
        this.vuUserId = vuUserId;
    }

    public String getVuUserName() {
        return vuUserName;
    }

    public void setVuUserName(String vuUserName) {
        this.vuUserName = vuUserName == null ? null : vuUserName.trim();
    }

    public String getVuPassword() {
        return vuPassword;
    }

    public void setVuPassword(String vuPassword) {
        this.vuPassword = vuPassword == null ? null : vuPassword.trim();
    }

    public Integer getVuStatus() {
        return vuStatus;
    }

    public void setVuStatus(Integer vuStatus) {
        this.vuStatus = vuStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getVuUserId() == null ? other.getVuUserId() == null : this.getVuUserId().equals(other.getVuUserId()))
                && (this.getVuUserName() == null ? other.getVuUserName() == null : this.getVuUserName().equals(other.getVuUserName()))
                && (this.getVuPassword() == null ? other.getVuPassword() == null : this.getVuPassword().equals(other.getVuPassword()))
                && (this.getVuStatus() == null ? other.getVuStatus() == null : this.getVuStatus().equals(other.getVuStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVuUserId() == null) ? 0 : getVuUserId().hashCode());
        result = prime * result + ((getVuUserName() == null) ? 0 : getVuUserName().hashCode());
        result = prime * result + ((getVuPassword() == null) ? 0 : getVuPassword().hashCode());
        result = prime * result + ((getVuStatus() == null) ? 0 : getVuStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vuUserId=").append(vuUserId);
        sb.append(", vuUserName=").append(vuUserName);
        sb.append(", vuPassword=").append(vuPassword);
        sb.append(", vuStatus=").append(vuStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}