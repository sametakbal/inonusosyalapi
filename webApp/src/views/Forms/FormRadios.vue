<template>
  <b-container fluid>
    <b-row>
       <div class="col-sm-12">
          <div class="iq-card position-relative inner-page-bg bg-primary" style="height: 150px;">
            <div class="inner-page-title">
                <h3 class="text-white">Form Radios Page</h3>
                <p class="text-white">lorem ipsum</p>
            </div>
          </div>
      </div>
      <b-col lg="6">
        <iq-card>
          <template v-slot:headerTitle>
            <h4 class="card-title">Default Radio Buttons</h4>
          </template>
          <template v-slot:body>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vulputate, ex ac venenatis mollis, diam nibh finibus leo</p>
            <template v-for="(item,index) in state">
              <b-form-radio inline v-model="stateActive[item[Object.keys(item)[0]]]" :name="item.name" :key="index" :value="item.value" :disabled="item.disabled">{{ item.label }}</b-form-radio>
            </template>
          </template>
        </iq-card>
      </b-col>
      <b-col lg="6">
        <iq-card>
          <template v-slot:headerTitle>
            <h4 class="card-title">Custom Radio Buttons</h4>
          </template>
          <template v-slot:body>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vulputate, ex ac venenatis mollis, diam nibh finibus leo</p>
            <template v-for="(item,index) in custom">
              <b-form-radio inline v-model="stateActive[item[Object.keys(item)[0]]]" :name="item.name" :key="index" :value="item.value" :disabled="item.disabled">{{ item.label }}</b-form-radio>
            </template>
          </template>
        </iq-card>
      </b-col>
      <b-col lg="6">
        <iq-card>
          <template v-slot:headerTitle>
            <h4 class="card-title">Custom Colored Radio Buttons</h4>
          </template>
          <template v-slot:body>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vulputate, ex ac venenatis mollis, diam nibh finibus leo</p>
            <template v-for="(item,index) in color">
              <b-form-radio class="custom-radio-color" inline v-model="stateActive.color" :color="item.color" name="color" :key="index" :value="item.value" :disabled="item.disabled">{{ item.label }}</b-form-radio>
            </template>
          </template>
        </iq-card>
      </b-col>
      <b-col lg="6">
        <iq-card>
          <template v-slot:headerTitle>
            <h4 class="card-title">Colored Radio Buttons</h4>
          </template>
          <template v-slot:body>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vulputate, ex ac venenatis mollis, diam nibh finibus leo</p>
            <template v-for="(item,index) in color">
              <b-form-radio class="custom-radio-color-checked" inline v-model="stateActive.color" :color="item.color" name="color" :key="index" :value="item.value" :disabled="item.disabled">{{ item.label }}</b-form-radio>
            </template>
          </template>
        </iq-card>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import { socialvue } from '../../config/pluginInit'

export default {
  name: 'FormRadios',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      stateActive: {
        single: 'active',
        disable: 'active',
        number: 'two',
        colorDisabled: 'five',
        color: 'danger'
      },
      state: [
        {
          name: 'single',
          label: 'False/Inactive',
          value: 'inactive',
          disabled: false
        },
        {
          name: 'single',
          label: 'True/Active',
          value: 'active',
          disabled: false
        },
        {
          name: 'disable',
          label: 'Disabled/Active',
          value: 'active',
          disabled: true
        },
        {
          name: 'disable-in',
          label: 'Disabled/Inactive',
          value: '',
          disabled: true
        }
      ],
      custom: [
        {
          name: 'number',
          label: 'One',
          value: 'one',
          disabled: false
        },
        {
          name: 'number',
          label: 'Two',
          value: 'two',
          disabled: false
        },
        {
          name: 'number',
          label: 'Three',
          value: 'three',
          disabled: false
        },
        {
          name: 'checked',
          label: 'Four',
          value: 'four',
          disabled: false
        },
        {
          name: 'colorDisabled',
          label: 'Five disabled',
          value: 'five',
          disabled: true
        },
        {
          name: 'seldis',
          label: 'Six selected and disabled',
          value: 'six',
          disabled: true
        }
      ],
      color: [
        {
          label: 'Primary',
          color: 'primary',
          value: 'primary'
        },
        {
          label: 'Success',
          color: 'success',
          value: 'success'
        },
        {
          label: 'Danger',
          color: 'danger',
          value: 'danger'
        },
        {
          label: 'Warning',
          color: 'warning',
          value: 'warning'
        },
        {
          label: 'Dark',
          color: 'dark',
          value: 'dark'
        },
        {
          label: 'Info',
          color: 'info',
          value: 'info'
        }
      ]
    }
  }
}
</script>
