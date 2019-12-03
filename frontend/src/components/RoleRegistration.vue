<template>
    <div class="container">
        <div class="section">
            <h4>
                Создание роли
            </h4>
            <div class="divider"></div>
        </div>

        <div class="row">
            <div class="col s12">
                <div class="row">
                    <div class="input-field col s4">
                        <input v-model="role.name" id="name" type="text" class="validate">
                        <label for="name">name</label>
                    </div>
                </div>


                <div class="row">
                    <div class="input-field col s12">
                        <input v-model="role.description" id="description" type="description" class="validate">
                        <label for="description">description</label>
                        <span class="helper-text" data-error="wrong" data-success="right">Helper text</span>
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
        name: "RoleRegistration",
        data() {
            return {
                role: {
                    "name": null,
                    "description": null,
                }
            };
        },
        methods: {
            send: function () {
                var path = this.$root.path + "roles/";
                this.$root.$http.post(path, this.role)
                    .then(
                        () => {
                            alert("Роль успешно создана");
                            this.$router.push("roles");
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