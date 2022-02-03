import { Switch, Route, Redirect } from "react-router-dom";

function Routes() {
  return (
    <Switch>
      <Route path="/" component={Home} exact />
      <CustomRoute isPrivate path="/livros" component={livros} />
      <CustomRoute isPrivate path="/editora" component={editora} />
      <Route path="/categoria" component={categoria} />
      <Route path="/exemplar" component={exemplar} />
    </Switch>
  );
}

export default Routes;
