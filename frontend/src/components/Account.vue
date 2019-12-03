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
                                    <v-btn color="blue darken-1" flat @click="deleteEmpl">Удалить сотрудника</v-btn>
                                </v-card-actions>
                            </template>


                            <v-card-title>
                                <span class="headline">Профиль пользователя</span>
                            </v-card-title>


                            <v-card-text>
                                <v-container grid-list-md>
                                    <v-layout wrap>

                                        <v-flex xs12 sm6 md4>
                                            <v-text-field label="Имя*"
                                                          v-model="account.firstName"
                                                          hint="Обязательное поле"
                                                          required></v-text-field>
                                        </v-flex>

                                        <v-flex xs12 sm6 md4>
                                            <v-text-field label=" Фамилия*"
                                                          v-model="account.lastName"
                                                          hint="Обязательное поле" required></v-text-field>
                                        </v-flex>

                                        <!--
                                                            <v-flex xs12 sm6 md4>
                                                              <v-text-field label="Отчество*"
                                                                            v-model="account.patronymic"
                                                                            hint="Обязательное поле" required></v-text-field>
                                                            </v-flex>
                                        -->

                                        <v-flex xs12>
                                            <v-text-field label="Email*"
                                                          v-model="account.email"
                                                          required></v-text-field>
                                        </v-flex>


                                        <template>
                                            <!--<template v-if="(principal.roles.includes('ADMIN') || principal.id === id)">-->

                                            <v-flex xs12>
                                                <v-text-field label="Password*"
                                                              v-model="account.password"
                                                              type="password" required></v-text-field>
                                            </v-flex>
                                        </template>


                                        <!--Если я адимнистратор, то могу редактировать роли пользователей-->
                                        <template>
                                            <!--<template v-if="principal.roles.includes('ADMIN')">-->


                                            <!--<v-container fluid>
                                              <p>Роли пользователя: {{ account.roles }}</p>
                                              <v-switch v-model="account.roles" label="Администратор" value="ADMIN"></v-switch>
                                              <v-switch v-model="account.roles" label="Технический специалист" value="TECH"></v-switch>
                                              <v-switch v-model="account.roles" label="HR" value="HR"></v-switch>
                                              <v-switch v-model="account.roles" label="Редактор" value="EDITOR"></v-switch>
                                            </v-container>-->


                                        </template>
                                        <!--Если я не адиминистратор, то я только вижу роли пользователей-->
                                        <!--<template v-else>
                                          <template v-for="role in account.roles">
                                            <v-chip>
                                              {{role}}
                                            </v-chip>
                                          </template>
                                        </template>-->


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
        name: "Account",
        props: ["id"],
        data() {
            return {
                account: {
                    "firstName": null,
                    "lastName": null,
                    "email": null,
                    "credentials": [
                        {"type": "password", "value": null}
                    ]
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
                var path = this.$root.path + "employees/" + this.id;
                console.log("Обновляем информацию о сотруднике" + path);

                console.log(this.account);
                var ResponseData = null;
                this.$root.$http
                    .put(path, this.account)
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
                var path = this.$root.path + "employees/";
                console.log("Создаем нового сотрудника" + path);

                console.log(this.account);
                var ResponseData = null;
                this.$root.$http
                    .post(path, this.account)
                    .then(response => {
                        ResponseData = response.data;
                    })
                    .then(
                        () => {
                            alert("Успех");
                            this.$router.push("employees");
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

            deleteEmpl: function () {
                var path = this.$root.path + "employees/" + this.id;

                alert("Сейчас будет произведено удаление сотрудника");
                var ResponseData = null;
                this.$root.$http
                    .delete(path)
                    .then(response => {
                        ResponseData = response.data;
                    })
                    .then(
                        () => {
                            alert("Сотрудник успешно удалён");
                            this.$router.push("employees");
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
                var path = this.$root.path + "employees/" + this.id;
                console.log('account path:' + path);
                this.$root.$http
                    .get(path)
                    .then(response => {
                        this.account = response.data;
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
            //  this.principal = this.$cookies.get("principal");
            //  if (this.id === undefined) {
            //    console.log("Создание нового пользователя");
            //    this.forCreating = true;
            //    this.account = {
            //      "name": "",
            //      "surname": "",
            //      "email": "",
            //      "password": "",
            //      "roles": ["TECH"]
            //    };
            //    this.submit = this.create;
            //    this.loading = false;
            //  }
            //  else {
            this.submit = this.update;
            this.download();
            //  }
        }
    }
</script>

<style scoped>
</style>
