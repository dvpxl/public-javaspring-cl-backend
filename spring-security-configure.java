@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public-api/**").permitAll() // Access to public API without authentication
            .antMatchers("/admin/**").hasRole("ADMIN") // Requires users to have the "ADMIN" role for URLs under /admin/
            .antMatchers("/user/**").hasRole("USER")   // Requires users to have the "USER" role for URLs under /user/
            .anyRequest().authenticated()               // All other URLs require authentication
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessURL("/dashboard", true)
            .permitAll()
            .and()
        .logout()
            .permitAll();
}
