package main.project910.service.impl;

import main.project910.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validateUSerName(String username) {
        if (username.length() > 3) {
            return true;
        }
        return false;
    }
}
