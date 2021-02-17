<template>
  <b-container fluid>
    <b-row>
      <div class="col-sm-12">
          <div class="iq-card position-relative inner-page-bg bg-primary" style="height: 150px;">
            <div class="inner-page-title">
                <h3 class="text-white">Pricing Page</h3>
                <p class="text-white">lorem ipsum</p>
            </div>
          </div>
      </div>
      <b-col lg="12">
        <iq-card>
          <template v-slot:body>
            <div class="table-responsive">
              <b-table-simple class="text-center">
                <b-thead>
                  <b-tr>
                    <th v-for="(item,index) in headerColumn" :key="item.key+index">{{ item.label }}</th>
                  </b-tr>
                </b-thead>
                <b-tbody>
                  <b-tr v-for="(item,index) in rows" :key="index">
                    <th scope="row">{{ item.name }}</th>
                    <td>
                      <template v-if="item.button">
                        <h2>{{ item.starter }} <small>{{ item.starter_per }}</small></h2>
                        <b-button variant="primary  mt-3">Purchase</b-button>
                      </template>
                      <i class="ri-check-line ri-2x text-success" v-if="item.starter && !item.button" />
                    </td>
                    <td>
                      <template v-if="item.button">
                        <h2>{{ item.business }} <small>{{ item.business_per }}</small></h2>
                        <b-button variant="primary  mt-3">Purchase</b-button>
                      </template>
                      <i class="ri-check-line ri-2x text-success" v-if="item.business && !item.button" />
                    </td>
                    <td>
                      <template v-if="item.button">
                        <h2>{{ item.enterprise }} <small>{{ item.enterprise_per }}</small></h2>.
                        <b-button variant="primary  mt-3">Purchase</b-button>
                      </template>
                      <i class="ri-check-line ri-2x text-success" v-if="item.enterprise && !item.button" />
                    </td>
                    <td>
                      <template v-if="item.button">
                        <h2>{{ item.unlimited }} <small>{{ item.unlimited_per }}</small></h2>
                        <b-button variant="primary  mt-3">Purchase</b-button>
                      </template>
                      <i class="ri-check-line ri-2x text-success" v-if="item.unlimited && !item.button" />
                    </td>
                  </b-tr>
                </b-tbody>
              </b-table-simple>
            </div>
          </template>
        </iq-card>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import { socialvue } from '../../config/pluginInit'

export default {
  name: 'Pricing',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      headerColumn: [
        {
          key: 'name',
          label: ''
        },
        {
          key: 'starter',
          label: 'Starter'
        },
        {
          key: 'business',
          label: 'Business'
        },
        {
          key: 'enterprise',
          label: 'Enterprise'
        },
        {
          key: 'unlimited',
          label: 'Unlimited'
        }
      ],
      rows: [
        {
          name: 'Email support',
          starter: true,
          business: true,
          enterprise: true,
          unlimited: true
        },
        {
          name: 'UI Kit',
          starter: false,
          business: true,
          enterprise: true,
          unlimited: true
        },
        {
          name: '100% support',
          starter: false,
          business: true,
          enterprise: true,
          unlimited: true
        },
        {
          name: 'Advance form',
          starter: true,
          business: true,
          enterprise: true,
          unlimited: true
        },
        {
          name: 'Custom shortcode',
          starter: false,
          business: false,
          enterprise: false,
          unlimited: true
        },
        {
          name: 'Thousand of Widgets',
          starter: false,
          business: false,
          enterprise: true,
          unlimited: true
        },
        {
          name: '',
          button: true,
          starter: '$19/',
          starter_per: ' Per month',
          business: '$39/',
          business_per: ' Per month',
          enterprise: '$119/',
          enterprise_per: ' Per month',
          unlimited: '$219/',
          unlimited_per: ' Per month'
        }
      ]
    }
  }
}
</script>
