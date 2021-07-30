import HomeView from './view/HomeView';
import './css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div>
          Applause Demo
        </div>
      </header>
      <HomeView/>
    </div>
  );
}

export default App;
