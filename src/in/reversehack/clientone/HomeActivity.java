package in.reversehack.clientone;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TextView tv1 = (TextView) findViewById(R.id.textView1);
        final TextView tv2 = (TextView) findViewById(R.id.textView2);
        LocationManager location_manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener location_listener = new LocationListener() {
			
			@Override
			public void onLocationChanged(Location location) {
				make_use_of_new_location(location);
				
			}
			private void make_use_of_new_location(Location location) {
				String latitude = "Current Latitude: " + location.getLatitude();
				String longitude = "Current Longitude: " + location.getLongitude();
				tv1.setText(latitude);
				tv2.setText(longitude);
			}
			@Override
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		location_manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, location_listener);
    }
}
