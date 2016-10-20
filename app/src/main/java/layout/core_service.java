package layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reddah.livestatus.livestatus.R;

import java.net.HttpURLConnection;
import java.net.URL;


public class core_service extends Fragment {

    View view;
    TextView tv_overall_status;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_overall_status, null);


        return view;
    }

}
