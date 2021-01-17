package com.example.HelpApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class alarmLokalizacja extends AppCompatActivity {
    String Podkategoria;
    String kategoria;
    String lokalizacjaUlica;
    String lokalizacjaLatitude;
    String lokalizacjaLongtitude;

    public static final String LOKALIZACJA_ULICA ="Alarm.lokalizacjaUlica";
    public static final String LOKALIZACJA_LONG ="Alarm.lokalizacjaLong";
    public static final String LOKALIZACJA_LAT ="Alarm.lokalizacjaLat";
    public static final String PODKATEGORIA ="Alarm.lokalizacjaPodkategoria";
    public static final String KATEGORIA ="Alarm.lokalizacjaKategoria";

    //umożliwienie edycji tekstu
    EditText  address;    //-WK-

    //Wprowadzenie przycisku
    Button getLocation;

    TextView latitude, longitude;    //-WK-

    // Klasa LocationManager dopuszcza dostęp do usług lokalizacji, locationListener odbiera lokalizacje
    public LocationManager locationManager;
    public LocationListener locationListener = new MyLocationListener();

    //Create string to store latitude ang longitude here
    String lat, lon;

    //czy sieć jest niedostępna
    private boolean gps_enable = false;
    private boolean network_enable = false;

    // generujemy adres pt.1
    Geocoder geocoder;
    List<Address> myaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_lokalizacja);

        Intent intent = getIntent();
        kategoria = intent.getStringExtra(alarm.KATEGORIA);
        switch (kategoria){
            case "Wypadek":
                    Podkategoria=intent.getStringExtra(alarmPodkategoria.PODKATEGORIA);
                break;
            case "Pomoc Medyczna":
                Podkategoria=intent.getStringExtra(alarmPodkategoriePomocMedyczna.PODKATEGORIA);
                break;
            case "Pożar":
                Podkategoria=intent.getStringExtra(alarmPodkategoriePozar.PODKATEGORIA);
                break;
            case "Przemoc, Przestępczość":
                Podkategoria=intent.getStringExtra(alarmPodkategoriePrzemoc.PODKATEGORIA);
                break;
            case "Inne":
                Podkategoria=intent.getStringExtra(alarmPodkategorieInne.PODKATEGORIA);
                break;

        }

        Button dalej =(Button) findViewById(R.id.buttonDalej);
        TextView kategoriaText = (TextView) findViewById(R.id.textViewKategoria) ;
        TextView podkategoriaText = (TextView) findViewById(R.id.textViewPodkategoria) ;
        kategoriaText.setText("Kategoria:" + kategoria);
        podkategoriaText.setText("Podkategoria : " + Podkategoria);

        //Zainicjowanie zmiennych

        latitude = (TextView) findViewById(R.id.latitude);
        longitude = (TextView) findViewById(R.id.longitude);

        getLocation = (Button) findViewById(R.id.get_location);

        address = (EditText) findViewById(R.id.address);

        //Inicjacja LocationMenadżera

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        //generacja kliknięcia

        getLocation.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //metoda do uzyskania lokalizacji
                getMyLocation();

            }
        });


        //odwołanie do pozwolenia na lokalizacje, wiecej opisane w nizej czesci tekstu
        checkLocationPermission();
















        dalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lokalizacjaUlica=address.getText().toString();
                lokalizacjaLatitude=latitude.getText().toString();
                lokalizacjaLongtitude=longitude.getText().toString();
                openCamera();
            }
        });
    }

    class MyLocationListener implements LocationListener {

        //zaimplementowane cztery metody polegające na zmianie lokalizacji (Używamy pierwszej - OnLocationChanged)
        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                locationManager.removeUpdates(locationListener);
                //Odwołuje się do Stringów około 45 wiersza
                lat = "" + location.getLatitude();
                lon = "" + location.getLongitude();

                //przypisanie tekstu
                latitude.setText(lat);
                longitude.setText(lon);


                //generowanie adresu pt.1
                geocoder = new Geocoder(alarmLokalizacja.this, Locale.getDefault());

                try {
                    myaddress = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String address1 = myaddress.get(0).getAddressLine(0);

                address.setText(address1);


            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }

    //określenie nazwy metody + wymaganie włączonego gps i sieci (gps, network)

    public void getMyLocation() {
        try {
            gps_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }

        try {
            network_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }

        if (!gps_enable && !network_enable) {
            AlertDialog.Builder builder = new AlertDialog.Builder(alarmLokalizacja.this);
            builder.setTitle("Attention");
            builder.setMessage("Sorry, location is not available, please enable location service...");

            builder.create().show();

        }
        if (gps_enable) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }

        if(network_enable){
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }

    }

    //wymaganie pozwolenia na lokalizacje (użyte są dwie lokalizacje (FINE i COURSE) dla wiekszej dokladnosci

    private boolean checkLocationPermission(){
        int location = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        List<String> listPermission = new ArrayList<>();

        if(location != PackageManager.PERMISSION_GRANTED){
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(location2 != PackageManager.PERMISSION_GRANTED){
            listPermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        }if(!listPermission.isEmpty()){
            ActivityCompat.requestPermissions(this,listPermission.toArray(new String[listPermission.size()]),
                    1);
        }


        return true;

    }

    public void openCamera() {
        Intent intent = new Intent(this, alarmCamera.class);
        intent.putExtra(LOKALIZACJA_ULICA,lokalizacjaUlica);
        intent.putExtra(LOKALIZACJA_LONG,lokalizacjaLongtitude);
        intent.putExtra(LOKALIZACJA_LAT,lokalizacjaLatitude);
        intent.putExtra(PODKATEGORIA,Podkategoria);
        intent.putExtra(KATEGORIA,kategoria);
        startActivity(intent);
    };


}