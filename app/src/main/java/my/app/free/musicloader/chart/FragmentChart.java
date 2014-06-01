package my.app.free.musicloader.chart;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import my.app.free.musicloader.Bot4Shared;
import my.app.free.musicloader.R;

/**
 * Created by loki on 2014. 5. 21..
 */
public class FragmentChart extends Fragment implements AdapterView.OnItemClickListener {

    private final String TAG = "FragmentChart";

    private ListView _chartList;
    private ChartListAdapter _adapter;
    private Bot4Shared _bot;

    public FragmentChart(Bot4Shared bot) {
        super();

        _bot = bot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        _adapter = new ChartListAdapter(getActivity(),
                R.layout.list_item_chart,
                new ArrayList<ChartItem>());

        _chartList = (ListView) view.findViewById(R.id.fragment_chart_list);
        _chartList.setOnItemClickListener(this);
        _chartList.setAdapter(_adapter);

        ChartAsyncTask task = new ChartAsyncTask(_bot, _adapter);
        task.execute();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
