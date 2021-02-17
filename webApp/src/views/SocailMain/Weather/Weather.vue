<template>
<b-row class="row">
  <b-col lg="3">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <div class="iq-card-body">
        <b-form>
          <b-form-group class="form-group" v-for="(item,index) in data" :key="index">
            <label>{{item.title}}</label>
            <b-select class="form-control" id="country-and-timezone">
              <b-select-option selected="" value="0" v-for="(value,index1) in item.option" :key="index1">{{value}}</b-select-option>
            </b-select>
          </b-form-group>
          <div class="form-group">
            <button type="submit" class="btn  btn-primary d-block w-100">Check wether</button>
          </div>
        </b-form>
      </div>
    </div>
  </b-col>
  <b-col lg="6">
    <b-card class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <b-card-body class="iq-card-body p-0">
       <div id="weather-chart" style="height: 405px;"></div>
      </b-card-body>
    </b-card>
  </b-col>
  <b-col lg="3">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height bg-primary rounded">
      <div class="iq-card-body p-4">
        <div class="text-center">
          <div class="d-flex align-items-center justify-content-center">
            <i class="ri-cloud-line font-size-32"></i>
            <div class="text-left pl-3">
              <h6 class="text-white">USA</h6>
              <p class="mb-0">Lorem ipsum</p>
            </div>
          </div>
          <div class="main-temp">
            <h1 class="text-white">53 <span>°</span></h1>
          </div>
          <ul class="d-flex align-items-center justify-content-between list-inline m-0 p-0">
            <li v-for="(item,index) in otherInfo " :key="index">
              <p class="text-white mb-0">{{item.heading}}</p>
              <i :class="item.class"></i>
              <h6 class="text-white">{{item.vlaue}} <span>&#8451;</span></h6>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </b-col>
  <b-col sm="12">
    <iq-card body-class="bg-info rounded">
      <template v-slot:body>
        <ul class="iq-week-data d-flex justify-content-between list-inline m-0 p-0">
          <li class="text-center p-4" v-for="(item,index) in dayWise" :key="index">
            <p class="mb-0">{{item.day}}</p>
            <div class="weather-icon mt-3 mb-3 font-size-20">
              <i :class="item.icon"></i>
            </div>
            <h6>{{item.value}}</h6>
          </li>
        </ul>
      </template>
    </iq-card>
  </b-col>

</b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
import * as am4core from '@amcharts/amcharts4/core'
import * as am4maps from '@amcharts/amcharts4/maps'
import am4themesAnimated from '@amcharts/amcharts4/themes/animated'
import am4geodataWorldLow from '@amcharts/amcharts4-geodata/worldLow'
export default {
  name: 'Weather',
  mounted () {
    socialvue.index()
    am4core.useTheme(am4themesAnimated)

    var chart = am4core.create('weather-chart', am4maps.MapChart)

    // eslint-disable-next-line camelcase
    chart.geodata = am4geodataWorldLow

    chart.projection = new am4maps.projections.Mercator()

    chart.homeZoomLevel = 6
    chart.homeGeoPoint = { longitude: 10, latitude: 51 }

    var polygonSeries = chart.series.push(new am4maps.MapPolygonSeries())
    polygonSeries.exclude = ['AQ']
    polygonSeries.useGeodata = true
    polygonSeries.nonScalingStroke = true
    polygonSeries.strokeOpacity = 0.5

    var imageSeries = chart.series.push(new am4maps.MapImageSeries())
    var imageTemplate = imageSeries.mapImages.template
    imageTemplate.propertyFields.longitude = 'longitude'
    imageTemplate.propertyFields.latitude = 'latitude'
    imageTemplate.nonScaling = true

    var image = imageTemplate.createChild(am4core.Image)
    image.propertyFields.href = 'imageURL'
    image.width = 50
    image.height = 50
    image.horizontalCenter = 'middle'
    image.verticalCenter = 'middle'

    var label = imageTemplate.createChild(am4core.Label)
    label.text = '{label}'
    label.horizontalCenter = 'middle'
    label.verticalCenter = 'top'
    label.dy = 20

    imageSeries.data = [{
      'latitude': 40.416775,
      'longitude': -3.703790,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/rainy-1.svg',
      'width': 32,
      'height': 32,
      'label': 'Madrid: +22C'
    }, {
      'latitude': 48.856614,
      'longitude': 2.352222,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/thunder.svg',
      'width': 32,
      'height': 32,
      'label': 'Paris: +18C'
    }, {
      'latitude': 52.520007,
      'longitude': 13.404954,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/cloudy-day-1.svg',
      'width': 32,
      'height': 32,
      'label': 'Berlin: +13C'
    }, {
      'latitude': 52.229676,
      'longitude': 21.012229,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/day.svg',
      'width': 32,
      'height': 32,
      'label': 'Warsaw: +22C'
    }, {
      'latitude': 41.872389,
      'longitude': 12.480180,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/day.svg',
      'width': 32,
      'height': 32,
      'label': 'Rome: +29C'
    }, {
      'latitude': 51.507351,
      'longitude': -0.127758,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/rainy-7.svg',
      'width': 32,
      'height': 32,
      'label': 'London: +10C'
    }, {
      'latitude': 59.329323,
      'longitude': 18.068581,
      'imageURL': 'https://www.amcharts.com/lib/images/weather/animated/rainy-1.svg',
      'width': 32,
      'height': 32,
      'label': 'Stockholm: +8C'
    } ]
  },
  components: {
  },
  data () {
    return {
      data: [
        {
          title: 'Country and Timezone',
          option: [
            'Country and Timezone',
            'United States (UTC-8)',
            'Chicago (UTC-5)',
            'New York (UTC-4)',
            'Anchorage (UTC-8)',
            'Honolulu (UTC-10)'
          ]
        },
        {
          title: 'Extended Days',
          option: [
            ' Extended Days',
            'Show Next Day',
            'Show Next 7 Day',
            ' Show Next 10 Day',
            'Show Next 30 Day'
          ]
        },
        {
          title: 'Temperature Unit',
          option: [
            ' F° (Farenheit',
            'C° (Celsius)'
          ]
        }
      ],
      otherInfo: [
        {
          heading: 'yesterday',
          class: 'ri-cloud-windy-line font-size-18',
          vlaue: '21'
        },
        {
          heading: 'today',
          class: 'ri-showers-line font-size-18',
          vlaue: '21'
        },
        {
          heading: 'tomorrow',
          class: 'ri-sun-cloudy-line font-size-18',
          vlaue: '21'
        }
      ],
      dayWise: [
        {
          day: 'Sunday',
          icon: 'ri-snowy-line',
          value: '11 ° 6 °'
        },
        {
          day: 'Monday',
          icon: 'ri-snowy-line',
          value: '12 °  8 °'
        },
        {
          day: 'Thuesday',
          icon: 'ri-sun-cloudy-line',
          value: '12 °  7 °'
        },
        {
          day: 'Weansday',
          icon: 'ri-sun-cloudy-line',
          value: '11 °  6 °'
        },
        {
          day: 'Thursday',
          icon: 'ri-heavy-showers-line',
          value: '11 °  8 °'
        },
        {
          day: 'Friday',
          icon: 'ri-sun-line',
          value: '13 °  5 °'
        },
        {
          day: 'Saturday',
          icon: 'ri-sun-line',
          value: '13 °  5 °'
        }
      ]
    }
  }
}
</script>
