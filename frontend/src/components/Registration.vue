<template>
    <div class="container">
        <div class="section">
            <h4>
                Создание пользователя
            </h4>
            <div class="divider"></div>
        </div>

        <div class="row">
            <div class="col s12">
                <div class="row">
                    <div class="input-field col s4">
                        <input v-model="account.firstName" id="first_name" type="text" class="validate">
                        <label for="first_name">First Name</label>
                    </div>

                    <div class="input-field col s4">
                        <input v-model="account.lastName" id="last_name" type="text" class="validate">
                        <label for="last_name">Last Name</label>
                    </div>

                    <!--          <div class="input-field col s4">
                                <input v-model="account.patronymic" id="patronymic" type="text"
                                       class="validate">
                                <label for="patronymic">Patronymic</label>
                              </div>-->
                </div>


                <div class="row">
                    <div class="input-field col s12">
                        <input v-model="account.email" id="email" type="email" class="validate">
                        <label for="email">Email</label>
                        <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                        <input v-model="account.password" id="password" type="password" class="validate">
                        <label for="password">Password</label>
                        <!--<span class="helper-text" data-error="wrong" data-success="right">Helper text</span>-->
                    </div>
                </div>


                <div class="section">
                    <button v-on:click="send" class="btn waves-effect waves-light indigo" name="action">Submit
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </div>

        <div class="divider"></div>


    </div>
</template>

<script>
    export default {
        name: "Registration",
        data() {
            return {
                account: {
                    "firstName": null,
                    "lastName": null,
                    "email": null,
                    "credentials": [
                        {"type": "password", "value": null}
                    ]
                }
            };
        },
        methods: {
            send: function () {
                var path = this.$root.path + "employees/";
                this.$root.$http.post(path, this.account)
                    .then(
                        () => {
                            alert("Сотрудник успешно создан");
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
            }
        }
    }
</script>

<style scoped>

</style>