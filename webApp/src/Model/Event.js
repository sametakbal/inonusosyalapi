import { is } from 'ramda'

export default class Event {
  constructor (event = {}) {
    this.id = is(String, event.id) ? event.id : this.uuidv4()
    this.calendarId = is(String, event.calendarId) ? event.calendarId : '1'
    this.title = is(String, event.title) ? event.title : ''
    this.body = is(String, event.body) ? event.body : ''
    this.isAllday = is(Boolean, event.isAllday) ? event.isAllday : false
    this.start = is(Object, event.start) ? (new Date(event.start._date)).toISOString() : event.start
    this.end = is(Object, event.end) ? (new Date(event.end._date)).toISOString() : event.end
    this.category = is(String, event.category) ? event.category : 'time'
    this.dueDateClass = is(String, event.dueDateClass) ? event.dueDateClass : ''
    this.color = this.eventColor(event.calendarId).color
    this.bgColor = this.eventColor(event.calendarId).bgColor
    this.dragBgColor = this.eventColor(event.calendarId).dragBgColor
    this.borderColor = this.eventColor(event.calendarId).borderColor
    this.customStyle = is(String, event.customStyle) ? event.customStyle : ''
    this.isFocused = is(Boolean, event.isFocused) ? event.isFocused : false
    this.isPending = is(Boolean, event.isPending) ? event.isPending : false
    this.isVisible = is(Boolean, event.isVisible) ? event.isVisible : true
    this.isReadOnly = is(Boolean, event.isReadOnly) ? event.isReadOnly : false
    this.goingDuration = is(String, event.goingDuration) ? event.goingDuration : ''
    this.comingDuration = is(String, event.comingDuration) ? event.comingDuration : ''
    this.recurrenceRule = is(String, event.recurrenceRule) ? event.recurrenceRule : ''
    this.state = is(String, event.state) ? event.state : 'Busy'
    this.raw = is(Object, event.raw) ? { 'memo': 'Sano zauhi buhbol igjodok ri figraipo akicaho ogramoz huwcic guisuar azpusofi fecje jeni rug.', 'hasToOrCc': false, 'hasRecurrenceRule': false, 'location': null, 'class': 'public', 'creator': { 'name': 'Albert McKinney', 'avatar': '//www.gravatar.com/avatar/93c7ab8252e7d7100ce7835b0fbd3937', 'company': 'Rohm & Haas Co.', 'email': 'koonesuc@epigujto.kz', 'phone': '(622) 497-8105' } } : {}
    this.isPrivate = is(Boolean, event.isPrivate) ? event.isPrivate : false
    this.location = is(String, event.location) ? event.location : '1'
    this.attendees = is(Array, event.attendees) ? event.attendees : []
  }

  uuidv4 () {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
      let r = Math.random() * 16 | 0; let v = c === 'x' ? r : (r & 0x3 | 0x8)
      return v.toString(16)
    })
  }
  eventColor (categoryID) {
    let pal = {}
    switch (categoryID) {
      case '1':
        pal = {
          color: '#ffffff',
          bgColor: '#9e5fff',
          dragBgColor: '#9e5fff',
          borderColor: '#9e5fff'
        }
        break
      case '2':
        pal = {
          color: '#ffffff',
          bgColor: '#00a9ff',
          dragBgColor: '#00a9ff',
          borderColor: '#00a9ff'
        }
        break
      case '3':
        pal = {
          color: '#ffffff',
          bgColor: '#ff5583',
          dragBgColor: '#ff5583',
          borderColor: '#ff5583'
        }
        break
      case '4':
        pal = {
          color: '#ffffff',
          bgColor: '#03bd9e',
          dragBgColor: '#03bd9e',
          borderColor: '#03bd9e'
        }
        break
      case '5':
        pal = {
          color: '#ffffff',
          bgColor: '#bbdc00',
          dragBgColor: '#bbdc00',
          borderColor: '#bbdc00'
        }
        break
      case '6':
        pal = {
          color: '#ffffff',
          bgColor: '#9d9d9d',
          dragBgColor: '#9d9d9d',
          borderColor: '#9d9d9d'
        }
        break
      case '7':
        pal = {
          color: '#ffffff',
          bgColor: '#ffbb3b',
          dragBgColor: '#ffbb3b',
          borderColor: '#ffbb3b'
        }
        break
      case '8':
        pal = {
          color: '#ffffff',
          bgColor: '#ff4040',
          dragBgColor: '#ff4040',
          borderColor: '#ff4040'
        }
        break
    }
    return pal
  }
}
