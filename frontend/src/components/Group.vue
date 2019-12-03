<template>
    <div>
        <div v-if="errors">
            <p>
                We're sorry, we're not able to retrieve
                this information at the moment, please try back later
            </p>
        </div>
        <div v-else>
            <div v-if="loading">Loading...</div>
            <div v-else>
                <div class="section">
                    <v-layout row justify-center>
                        <!--карточка-->
                        <v-card>

                            <template>
                                <!--<template v-if="(principal.roles.includes('ADMIN'))">-->
                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="blue darken-1" flat @click="deleteRole">Удалить группу</v-btn>
                                </v-card-actions>
                            </template>


                            <v-card-title>
                                <span class="headline">Страница группы</span>
                            </v-card-title>


                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>

                                        <v-flex xs12 sm6 md4>
                                            <v-text-field label="name*"
                                                          v-model="group.name"
                                                          hint="Обязательное поле"
                                                          required></v-text-field>
                                        </v-flex>


                                    </v-layout>
                                </v-container>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>

                                <template>
                                    <!--<template v-if="(principal.roles.includes('ADMIN') || principal.employeeId === id)">-->
                                    <v-btn color="blue darken-1" flat @click="submit">Сохранить</v-btn>
                                </template>

                            </v-card-actions>
                        </v-card>

                    </v-layout>

                    <!--Если я адимнистратор или это мой аккаунт-->

                </div>

                <div class="divider"></div>


            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Group",
        props: ["id"],
        data() {
            return {
                group: {
                    "name": null
                },
                principal: null,
                errors: false,
                loading: true
            };
        },
        methods: {

            submit: function () {
                alert("Эта функция ничего не делает. Ошибка при загрузке страницы");
            },
            update: function () {
                var path = this.$root.path + "groups/" + this.id;
                console.log("Обновляем информацию о группе" + path);

                console.log(this.group);
                var ResponseData = null;
                this.$root.$http
                    .put(path, this.group)
                    .then(response => {
                        ResponseData = response.data;
                    })
                    .catch(error => {
                        console.log(error);
                        this.errors = true;
                    })
                    .finally(() => {
                    });
            },

            create: function () {
                var path = this.$root.path + "groups/";
                console.log("Создаем новую группу" + path);

                console.log(this.group);
                var ResponseData = null;
                this.$root.$http
                    .post(path, this.group)
                    .then(response => {
                        ResponseData = response.data;
                    })
                    .then(
                        () => {
                            alert("Успех");
                            this.$router.push("groups");
                        }
                    )
                    .catch(error => {
                        alert("Возникли ошибки");
                        console.log(error);
                        this.errors = true;
                    })
                    .finally(() => {
                    });
            },

            deleteRole: function () {
                var path = this.$root.path + "groups/" + this.id;

                alert("Сейчас будет произведено удаление группы");
                var ResponseData = null;
                this.$root.$http
                    .delete(path)
                    .then(response => {
                        ResponseData = response.data;
                    })
                    .then(
                        () => {
                            alert("Группа успешно удалена");
                            this.$router.push("groups");
                        }
                    )
                    .catch(error => {
                        alert("Возникли ошибки");
                        console.log(error);
                        this.errors = true;
                    })
                    .finally(() => {
                    });
            },


            download: function () {
                var path = this.$root.path + "groups/" + this.id;
                console.log('group path:' + path);
                this.$root.$http
                    .get(path)
                    .then(response => {
                        this.group = response.data;
                    })
                    .catch(error => {
                        console.log(error);
                        this.errors = true;
                    })
                    .finally(() => {
                        this.loading = false;
                    });
            }
        },
        mounted: function () {
            this.submit = this.update;
            this.download();
        }
    }
</script>

<style scoped>
</style>
