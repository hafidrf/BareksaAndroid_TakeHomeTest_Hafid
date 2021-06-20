package com.hafidrf.bareksaandroid_takehometest.ui.imbal_hasil

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.hafidrf.bareksaandroid_takehometest.R
import kotlinx.android.synthetic.main.data_content_layout.view.*
import kotlinx.android.synthetic.main.fragment_chart_template.*

class ChartTemplateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart_template, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lineDataSet1 = LineDataSet(lineChartDataset1(), "")
        lineDataSet1.custom("#668054")
        val lineDataSet2 = LineDataSet(lineChartDataset2(), "")
        lineDataSet2.custom("#725E9C")
        val lineDataSet3 = LineDataSet(lineChartDataset3(), "")
        lineDataSet3.custom("#6D98B6")

        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(lineDataSet1)
        dataSets.add(lineDataSet2)
        dataSets.add(lineDataSet3)

        val data = LineData(dataSets)
        line_chart.data = data
        line_chart.invalidate()

        val description = Description()
        description.isEnabled = false
        line_chart.description = description

        line_chart.setBackgroundColor(Color.WHITE)
        line_chart.setDrawGridBackground(false)
        line_chart.setDrawBorders(false)
        line_chart.setBorderColor(Color.WHITE)
        line_chart.setTouchEnabled(false)
        line_chart.isDragEnabled = false
        line_chart.setScaleEnabled(false)
        line_chart.setPinchZoom(false)

        val legend = line_chart.legend
        legend.isEnabled = false

        line_chart.axisLeft.isEnabled = false
        line_chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        line_chart.xAxis.setDrawGridLines(false)
        line_chart.xAxis.setLabelCount(5, true)
        val xAxisValue = ArrayList<String>()
        xAxisValue.add("Jul 19")
        xAxisValue.add("Okt 19")
        xAxisValue.add("Jan 20")
        xAxisValue.add("Apr 20")
        xAxisValue.add("Jul 20")
        line_chart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValue)

        line_chart.axisRight.isEnabled = true
        line_chart.axisRight.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        line_chart.axisRight.setDrawGridLines(true)
        line_chart.axisRight.setLabelCount(9, true)
        line_chart.axisRight.setDrawAxisLine(false)
        val yAxisValue = ArrayList<String>()
        yAxisValue.add("0 %")
        yAxisValue.add("5 %")
        yAxisValue.add("10 %")
        yAxisValue.add("15 %")
        yAxisValue.add("20 %")
        yAxisValue.add("25 %")
        yAxisValue.add("30 %")
        yAxisValue.add("35 %")
        yAxisValue.add("40 %")
        line_chart.axisRight.axisMinimum = 0f
        line_chart.axisRight.axisMaximum = 8f
        line_chart.axisRight.valueFormatter = IndexAxisValueFormatter(yAxisValue)

    }

    private fun lineChartDataset1(): ArrayList<Entry>{
        val dataSet = ArrayList<Entry>()
        dataSet.add(Entry(0f, 0f))
        dataSet.add(Entry(1f, 0.5f))
        dataSet.add(Entry(2f, 2.5f))
        dataSet.add(Entry(3f, 3.5f))
        dataSet.add(Entry(4f, 4.5f))
        return dataSet
    }

    private fun lineChartDataset2(): ArrayList<Entry>{
        val dataSet = ArrayList<Entry>()
        dataSet.add(Entry(0f, 0f))
        dataSet.add(Entry(1f, 2.5f))
        dataSet.add(Entry(2f, 7f))
        dataSet.add(Entry(3f, 15f))
        dataSet.add(Entry(4f, 25f))
        return dataSet
    }

    private fun lineChartDataset3(): ArrayList<Entry>{
        val dataSet = ArrayList<Entry>()
        dataSet.add(Entry(0f, 0f))
        dataSet.add(Entry(1f, 5f))
        dataSet.add(Entry(2f, 10f))
        dataSet.add(Entry(3f, 20f))
        dataSet.add(Entry(4f, 40f))
        return dataSet
    }

    private fun LineDataSet.custom(colorString: String){
        this.color = Color.parseColor(colorString)
        this.lineWidth = 2.5f
        this.setDrawCircles(true)
        this.setDrawCircleHole(true)
        this.setCircleColor(Color.parseColor(colorString))
        this.circleRadius = 7f
        this.circleHoleRadius = 4.5f
        this.setDrawValues(false)
    }
}

