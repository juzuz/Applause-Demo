import HomeView from './view/HomeView';
import './css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div className="App">
        <ToastContainer/>
      <HomeView/>
    </div>
  );
}

export default App;
