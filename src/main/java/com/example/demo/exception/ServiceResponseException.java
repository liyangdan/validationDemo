package com.example.demo.exception;

/**
 * @author liyangdan
 * @date 2018/12/15 2:19 PM
 */

public class ServiceResponseException extends RuntimeException{

    private static final long serialVersionUID = -8529184653469363478L;
    private String message = "service.unknown.exception";

    public ServiceResponseException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ServiceResponseException)) {
            return false;
        } else {
            ServiceResponseException other = (ServiceResponseException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    public boolean canEqual(Object other) {
        return other instanceof ServiceResponseException;
    }

    @Override
    public String toString() {
        return "ServiceResponseException(message=" + this.getMessage() + ")";
    }

}