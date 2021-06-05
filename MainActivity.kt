package lilcode.aop.p2.c05.homework_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//MPAndroidChart import
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

class MainActivity : AppCompatActivity() {
    //선 그래프
    private val lineChart:LineChart by lazy{
        findViewById<LineChart>(R.id.chart)
    }

    //ArrayList<Entry> entry_chart = new ArrayList<>();
    private var entry_chart: ArrayList<Entry> = ArrayList<Entry>()

    //lineChart = (LineChart) findViewById(R.id.chart);//layout의 id
    //LineData chartData = new LineData()

    //entry_chart.add(new Entry(x값, y값));
    /* 만약 (2, 3) add하고 (2, 5)한다고해서
    기존 (2, 3)이 사라지는게 아니라 x가 2인곳에 y가 3, 5의 점이 찍힘 */

    //LineDataSet lineDataSet = new LineDataSet(entry_chart, "꺽은선1");
    //chartData.addDataSet(lineDataSet);



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var chartData:LineData = LineData()
        entry_chart.add(Entry(10f,20f))
        entry_chart.add(Entry(20f,20f))
        entry_chart.add(Entry(30f,20f))
        entry_chart.add(Entry(40f,60f))
        entry_chart.add(Entry(50f,80f))

        var lineDataSet: LineDataSet = LineDataSet(entry_chart, "LineGraph")
        chartData.addDataSet(lineDataSet)

        lineChart.setData(chartData);

        lineChart.invalidate();
    }
}