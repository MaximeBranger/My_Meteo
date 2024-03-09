package com.example.my_meteo.Controller;

import com.example.my_meteo.Entity.InfoClimatResponse;
import com.example.my_meteo.Utils.AreaChartCustom;
import com.example.my_meteo.Utils.BarChartCustom;
import com.example.my_meteo.Utils.LineChartCustom;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.SVGPath;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Getter
@Setter
public class WeatherTabController implements Initializable {
    private LocalDate date;

    protected SuperController superController;

    @FXML
    public AreaChart areaChart;

    @FXML
    public LineChart lineChart;

    @FXML
    public BarChart barChart;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public SVGPath arrowWind;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Platform.runLater(() -> {
            this.setSuperController(SuperController.getInstance());
            InfoClimatResponse infoClimatResponse = this.getSuperController().getInfoClimatResponse();

            AreaChartCustom areaChartCustom = new AreaChartCustom();
            LineChartCustom lineChartCustom = new LineChartCustom();
            BarChartCustom barChartCustom = new BarChartCustom();

            anchorPane.getChildren().add(areaChartCustom.createAreaChart(infoClimatResponse, this.date));
            anchorPane.getChildren().add(lineChartCustom.createLineChart(infoClimatResponse, this.date));
            anchorPane.getChildren().add(barChartCustom.createBarChart(infoClimatResponse, this.date));

            arrowWind.setRotate(infoClimatResponse.getClosestForecastByDate(this.date).getWind_direction().getWind_dir_10m());
            arrowWind.setScaleX(0.5);
            arrowWind.setScaleY(0.5);
        });
    }

    public void setData(LocalDate date) {
        this.date = date;
    }
}
