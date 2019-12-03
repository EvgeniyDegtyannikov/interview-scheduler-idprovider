<template>
    <div>

        <div v-if="errored">
            <p>
                We're sorry, we're not able to retrieve
                this information at the moment, please try back later
            </p>
        </div>
        <div v-else>
            <div v-if="loading">Loading...</div>
            <div v-else>
                <!--Table-->
                <div>
                    <v-card>
                        <!--<template v-if="principal.roles.includes('ADMIN')">-->
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn
                                    color="blue darken-1"
                                    flat
                                    to="groupregistration">
                                Добавить группу
                            </v-btn>
                        </v-card-actions>
                        <!--</template>-->

                        <!--<v-card-title>-->
                        <!--<span class="headline">Список групп</span>-->
                        <!--</v-card-title>-->

                        <v-card-title>
                            <v-spacer></v-spacer>
                            <v-text-field
                                    v-model="groupSearch"
                                    append-icon="search"
                                    label="Поиск"
                                    single-line
                                    hide-details
                            ></v-text-field>
                        </v-card-title>

                        <v-data-table
                                :headers="groupHeaders"
                                :items="groups"
                                :search="groupSearch"
                                class="elevation-1">
                            <template slot="items" slot-scope="props" v-on:click="goto(props.item.id)">
                                <tr @click="goto(props.item.id)">
                                    <td class="text-xs-centre">{{ props.item.id }}</td>
                                    <td class="text-xs-centre">{{ props.item.name }}</td>
                                </tr>
                            </template>
                            <template slot="no-data">
                                <v-alert :value="true" color="error" icon="warning">
                                    В базе отсутствуют группы
                                </v-alert>
                            </template>
                            <v-alert slot="no-results" :value="true" color="error" icon="warning">
                                Ничего не найдено по запросу: "{{groupSearch}}".
                            </v-alert>
                        </v-data-table>


                    </v-card>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        firstName: "GroupsPage",
        data() {
            return {
                groups: null,
                loading: true,
                errored: false,
                principal: null,


                groupSearch: "",
                groupHeaders: [
                    {
                        text: '#id',
                        align: 'left',
                        sortable: false,
                        value: 'id'
                    },
                    {text: 'name', sortable: false, value: 'name'},
                ],
            };
        },
        methods: {
            init: function () {
            },
            goto: function (id) {
                this.$router.push({name: 'Group', params: {id: id}});
            },

            download: function () {
                this.$root.$http
                    .get(this.$root.path + "groups/")
                    .then(response => {
                        this.groups = response.data;
                    })
                    // .catch(error => {
                    //   this.errored = true;
                    // })
                    .finally(() => {
                        this.loading = false;
                    });
            },

        },
        mounted() {
            //this.principal = this.$cookies.get("principal");
            this.download();
        }
    }
</script>


<style scoped>
</style>
