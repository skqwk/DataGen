import React, {useState} from 'react';
import { Container, Divider, Typography, TextField, Box, Button, Stack, Paper } from '@mui/material';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import PlayCircleFilledWhiteIcon from '@mui/icons-material/PlayCircleFilledWhite';
import Field from 'components/Field';
import Header from 'components/Header';


function App() {

  const [inputs, setInputs] = useState([]);
  const [request, setRequest] = useState({})
  const [fields, setFields] = useState({});
  const [name, setName] = useState("");

  const [idx, setIdx] = useState(0);

  const deleteField = (idx) => {
    console.log(idx);
    // console.log(inputs);


    console.log("Try remove");
    console.log(inputs);
    let filteredInputs = inputs.filter((input) => input.props.idx != idx);
    console.log(filteredInputs);


    delete fields[idx];
    setFields(fields);
    setInputs(inputs);
  }

  const addInput = () => {
    setInputs([...inputs, <Field idx={idx} fields={fields} setFields={setFields} deleteField={deleteField} inputs={inputs} setInputs={setInputs}/>])
    console.log(inputs);
    setIdx(idx + 1);
  }

  const generate = () => {
    let request = {name, fields};
    console.log(JSON.stringify(request));


  }

  return (
    <Container component={Paper} sx={{display: "flex", alignItems: "center", flexDirection: "column", p: 5}} >

      <Typography align="center" sx={{mb: 5}}>DATAGEN</Typography>
      <Box width="500px">
        <TextField id="outlined-basic" name="name" fullWidth label="Наименование cущности" variant="outlined" onChange={(e) => setName(e.target.value)}/>
        <Typography>Поля</Typography>
        <Divider/>

        {inputs.length
        ? <Header/>
        : null}

        {inputs.map((input) => input)}

        <Stack  sx={{mt: 2, align: "center"}} direction="row" justifyContent="space-around">
        <Button  variant="contained" endIcon={<AddCircleIcon/>} onClick={addInput}>Добавить</Button>
        {inputs.length 
        ? <Button variant="contained" endIcon={<PlayCircleFilledWhiteIcon/>} color="success" onClick={generate}>Генерировать</Button>
        : null
        }
        </Stack>
      </Box>

    </Container>
  );
}

export default App;
