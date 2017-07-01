## Módulo de Autenticação

1. Colocar o scripts no `index.html`
```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/ngStorage/0.3.6/ngStorage.min.js" type="text/javascript"></script>
<script src="https://rawgit.com/cwi-crescer-2017-1/instrutores/master/modulo-05-angularjs/auth/auth.module.js" type="text/javascript"></script>
```

2. Adicionar módulo `auth` como dependência.
```javascript
angular.module('app', ['ngRoute', 'auth']);
```

3. Configurar módulo.
```javascript
// Configurações utilizadas pelo módulo de autenticação (authService)
angular.module('app').constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:3000/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/privado',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/home'
});
```

4. Usar conforme exemplo: [link](https://github.com/cwi-crescer-2017-1/instrutores/blob/master/modulo-05-angularjs/autenticacao).
