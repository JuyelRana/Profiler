package dreamycoding.com.profiler;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Juyel on 10/19/2017.
 */

public class FragmentTemplate extends Fragment implements Contract.View{

    //private Contract.Presnter presnter;

    public FragmentTemplate() {
        // Required empty public constructor
    }

    public static FragmentTemplate newInstance(){
        FragmentTemplate fragment = new FragmentTemplate();
        return fragment;
    }

    @Override
    public void setPresnter(Contract.Presnter presnter) {
        this.presnter = presnter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //This is important. It helps our View/Presenter/Service service orientation
        this.setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);
        //Where we assign our views
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Where we create presenter if need
        if (presnter == null){
            presnter = new Presenter();
        }

        presnter.subscribe();
    }

    @Override
    public void onDestroy() {
        presnter.unsubscribe();
        super.onDestroy();
    }
}
