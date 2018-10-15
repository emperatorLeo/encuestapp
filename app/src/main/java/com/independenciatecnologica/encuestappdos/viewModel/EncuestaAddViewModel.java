package com.independenciatecnologica.encuestappdos.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class EncuestaAddViewModel extends ViewModel {
    MutableLiveData<String>name,lastName,dni,email,dateBith,categories,description;

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }

    public void setLastName(MutableLiveData<String> lastName) {
        this.lastName = lastName;
    }

    public MutableLiveData<String> getDni() {
        return dni;
    }

    public void setDni(MutableLiveData<String> dni) {
        this.dni = dni;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(MutableLiveData<String> email) {
        this.email = email;
    }

    public MutableLiveData<String> getDateBith() {
        return dateBith;
    }

    public void setDateBith(MutableLiveData<String> dateBith) {
        this.dateBith = dateBith;
    }

    public MutableLiveData<String> getCategories() {
        return categories;
    }

    public void setCategories(MutableLiveData<String> categories) {
        this.categories = categories;
    }

    public MutableLiveData<String> getDescription() {
        return description;
    }

    public void setDescription(MutableLiveData<String> description) {
        this.description = description;
    }
}
