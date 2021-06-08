package com.wsl.login.database.entities;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class EUser_Factory implements Factory<EUser> {
  private final Provider<String> uuid_userProvider;

  private final Provider<String> customer_idProvider;

  private final Provider<String> nameProvider;

  private final Provider<String> last_nameProvider;

  private final Provider<String> usernameProvider;

  private final Provider<String> emailProvider;

  private final Provider<String> countryProvider;

  private final Provider<String> stateProvider;

  private final Provider<String> cityProvider;

  private final Provider<String> postal_codeProvider;

  private final Provider<String> country_codeProvider;

  private final Provider<String> phoneProvider;

  private final Provider<String> addressProvider;

  private final Provider<String> latitudeProvider;

  private final Provider<String> longitudeProvider;

  private final Provider<String> sexProvider;

  private final Provider<String> typeOfUserProvider;

  private final Provider<String> tokendeviceProvider;

  private final Provider<String> image_uriProvider;

  private final Provider<String> passwordProvider;

  public EUser_Factory(Provider<String> uuid_userProvider, Provider<String> customer_idProvider,
      Provider<String> nameProvider, Provider<String> last_nameProvider,
      Provider<String> usernameProvider, Provider<String> emailProvider,
      Provider<String> countryProvider, Provider<String> stateProvider,
      Provider<String> cityProvider, Provider<String> postal_codeProvider,
      Provider<String> country_codeProvider, Provider<String> phoneProvider,
      Provider<String> addressProvider, Provider<String> latitudeProvider,
      Provider<String> longitudeProvider, Provider<String> sexProvider,
      Provider<String> typeOfUserProvider, Provider<String> tokendeviceProvider,
      Provider<String> image_uriProvider, Provider<String> passwordProvider) {
    this.uuid_userProvider = uuid_userProvider;
    this.customer_idProvider = customer_idProvider;
    this.nameProvider = nameProvider;
    this.last_nameProvider = last_nameProvider;
    this.usernameProvider = usernameProvider;
    this.emailProvider = emailProvider;
    this.countryProvider = countryProvider;
    this.stateProvider = stateProvider;
    this.cityProvider = cityProvider;
    this.postal_codeProvider = postal_codeProvider;
    this.country_codeProvider = country_codeProvider;
    this.phoneProvider = phoneProvider;
    this.addressProvider = addressProvider;
    this.latitudeProvider = latitudeProvider;
    this.longitudeProvider = longitudeProvider;
    this.sexProvider = sexProvider;
    this.typeOfUserProvider = typeOfUserProvider;
    this.tokendeviceProvider = tokendeviceProvider;
    this.image_uriProvider = image_uriProvider;
    this.passwordProvider = passwordProvider;
  }

  @Override
  public EUser get() {
    return newInstance(uuid_userProvider.get(), customer_idProvider.get(), nameProvider.get(), last_nameProvider.get(), usernameProvider.get(), emailProvider.get(), countryProvider.get(), stateProvider.get(), cityProvider.get(), postal_codeProvider.get(), country_codeProvider.get(), phoneProvider.get(), addressProvider.get(), latitudeProvider.get(), longitudeProvider.get(), sexProvider.get(), typeOfUserProvider.get(), tokendeviceProvider.get(), image_uriProvider.get(), passwordProvider.get());
  }

  public static EUser_Factory create(Provider<String> uuid_userProvider,
      Provider<String> customer_idProvider, Provider<String> nameProvider,
      Provider<String> last_nameProvider, Provider<String> usernameProvider,
      Provider<String> emailProvider, Provider<String> countryProvider,
      Provider<String> stateProvider, Provider<String> cityProvider,
      Provider<String> postal_codeProvider, Provider<String> country_codeProvider,
      Provider<String> phoneProvider, Provider<String> addressProvider,
      Provider<String> latitudeProvider, Provider<String> longitudeProvider,
      Provider<String> sexProvider, Provider<String> typeOfUserProvider,
      Provider<String> tokendeviceProvider, Provider<String> image_uriProvider,
      Provider<String> passwordProvider) {
    return new EUser_Factory(uuid_userProvider, customer_idProvider, nameProvider, last_nameProvider, usernameProvider, emailProvider, countryProvider, stateProvider, cityProvider, postal_codeProvider, country_codeProvider, phoneProvider, addressProvider, latitudeProvider, longitudeProvider, sexProvider, typeOfUserProvider, tokendeviceProvider, image_uriProvider, passwordProvider);
  }

  public static EUser newInstance(String uuid_user, String customer_id, String name,
      String last_name, String username, String email, String country, String state, String city,
      String postal_code, String country_code, String phone, String address, String latitude,
      String longitude, String sex, String typeOfUser, String tokendevice, String image_uri,
      String password) {
    return new EUser(uuid_user, customer_id, name, last_name, username, email, country, state, city, postal_code, country_code, phone, address, latitude, longitude, sex, typeOfUser, tokendevice, image_uri, password);
  }
}
