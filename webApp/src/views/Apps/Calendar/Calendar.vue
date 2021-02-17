<template>
    <b-row>
      <b-col cols="12">
        <div class="iq-card mb-0" style="border-bottom-left-radius: 0; border-bottom-right-radius: 0" id="menu">
          <div id="menu-navi" class="iq-card-body d-flex align-items-center justify-content-between" @click="onClickNavi($event)">
            <button type="button" class="btn mr-1 btn-outline-primary" data-action="move-today">Today</button>
            <div class="d-flex">
              <button type="button" class="btn btn-link iq-bg-primary" data-action="move-prev">
                <i class="fa fa-chevron-left mr-0" data-action="move-prev" />
              </button>
              <h5 id="renderRange" class="render-range mt-1 mx-4">{{ dateRange }}</h5>
              <button type="button" class="btn btn-link iq-bg-primary" data-action="move-next">
                <i class="fa fa-chevron-right mr-0" data-action="move-prev" />
              </button>
            </div>
            <div>
              <b-form-radio-group
                id="btn-radios-1"
                v-model="selectedView"
                :options="viewModeOptions"
                buttons
                button-variant="primary"
                name="radios-btn-default"
              ></b-form-radio-group>
            </div>
          </div>
        </div>
      </b-col>
      <b-col cols="12">
        <calendar style="height: 800px" id="calender"
                  ref="tuiCal"
                  :useDetailPopup="useDetailPopup"
                  :view="selectedView"
                  :calendars="calendarList"
                  :schedules="scheduleList"
                  :template="template"
                  :taskView="true"
                  :scheduleView="true"
                  :month="month"
                  :week="week"
                  :disableDblClick="disableDblClick"
                  :isReadOnly="isReadOnly"
                  @clickSchedule="onClickSchedule"
                  @clickDayname="onClickDayname"
                  @beforeCreateSchedule="onBeforeCreateSchedule"
                  @beforeUpdateSchedule="onBeforeUpdateSchedule"
                  @beforeDeleteSchedule="onBeforeDeleteSchedule"
        />
      </b-col>
    </b-row>
</template>
<script>
import 'tui-time-picker/dist/tui-time-picker.css'
import 'tui-date-picker/dist/tui-date-picker.css'
import 'tui-calendar/dist/tui-calendar.css'
import Event from '../../../Model/Event'
import { CalenderList, Events } from '../../../FackApi/api/calendar'
import { Calendar } from '@toast-ui/vue-calendar'
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'App',
  components: {
    'calendar': Calendar
  },
  data () {
    return {
      viewModeOptions: [
        {
          text: 'Monthly',
          value: 'month'
        },
        {
          text: 'Weekly',
          value: 'week'
        },
        {
          text: 'Daily',
          value: 'day'
        }
      ],
      dateRange: '',
      selectedView: 'month',
      calendarList: CalenderList,
      scheduleList: [],
      template: {
        milestone (schedule) {
          return `<span style="color:#3F3F3F;background-color: ${schedule.bgColor};">${schedule.title}</span>`
        },
        milestoneTitle () {
          return '<span class="tui-full-calendar-left-content">Milestone</span>'
        },
        allday (schedule) {
          return `<i class="fa fa-users"></i> ${schedule.title}`
        },
        alldayTitle () {
          return '<span class="tui-full-calendar-left-content">All Day</span>'
        }
      },
      month: {
        startDayOfWeek: 0
      },
      week: {
        showTimezoneCollapseButton: true,
        timezonesCollapsed: true
      },
      taskView: true,
      scheduleView: true,
      useDetailPopup: true,
      disableDblClick: true,
      isReadOnly: false
    }
  },
  watch: {
    selectedView (newValue) {
      this.$refs.tuiCal.invoke('changeView', newValue, true)
      this.setRenderRangeText()
    }
  },
  methods: {
    init () {
      this.setRenderRangeText()
    },
    setRenderRangeText () {
      const { invoke } = this.$refs.tuiCal
      const view = invoke('getViewName')
      const calDate = invoke('getDate')
      const rangeStart = invoke('getDateRangeStart')
      const rangeEnd = invoke('getDateRangeEnd')
      const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
      let year = calDate.getFullYear()
      let month = calDate.getMonth() + 1
      let date = calDate.getDate()
      let dateRangeText = ''
      let endMonth, endDate, start, end
      switch (view) {
        case 'month':
          dateRangeText = `${months[month]} ${year}`
          break
        case 'week':
          year = rangeStart.getFullYear()
          month = rangeStart.getMonth() + 1
          date = rangeStart.getDate()
          endMonth = rangeEnd.getMonth() + 1
          endDate = rangeEnd.getDate()
          start = `${months[month]} ${date}`
          end = `${endDate} ${months[endMonth]}, ${year}`
          dateRangeText = `${start} - ${end}`
          break
        default:
          dateRangeText = `${date} ${months[month]} ${year}`
      }
      this.dateRange = dateRangeText
    },
    onClickNavi (event) {
      if (event.target.tagName === 'BUTTON' || event.target.tagName === 'I') {
        const { target } = event
        let action = target.dataset ? target.dataset.action : target.getAttribute('data-action')
        action = action.replace('move-', '')
        this.$refs.tuiCal.invoke(action)
        this.setRenderRangeText()
      }
    },
    onClickSchedule (res) {
      /* console.group('onClickSchedule')
      console.log('MouseEvent : ', res.event)
      console.log('Calendar Info : ', res.calendar)
      console.log('Schedule Info : ', res.schedule)
      console.groupEnd() */
    },
    onClickDayname (res) {
      // view : week, day
      /* console.group('onClickDayname')
      console.log(res.date)
      console.groupEnd() */
    },
    onBeforeUpdateSchedule (res) {
      const idx = this.scheduleList.findIndex(item => item.id === res.schedule.id)
      let updatedEvent = { ...res.schedule, ...res.changes }
      this.$set(this.scheduleList, idx, new Event(updatedEvent))
    },
    onBeforeCreateSchedule (res) {
      let event = new Event(res)
      this.scheduleList.push(event)
    },
    onBeforeDeleteSchedule (res) {
      const idx = this.scheduleList.findIndex(item => item.id === res.schedule.id)
      this.scheduleList.splice(idx, 1)
    }
  },
  mounted () {
    this.init()
    socialvue.index()
    this.scheduleList = Events
  }
}
</script>
