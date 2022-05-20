import AddCircleIcon from '@mui/icons-material/AddCircle';
import PlayCircleFilledWhiteIcon from '@mui/icons-material/PlayCircleFilledWhite';
import RemoveIcon from '@mui/icons-material/Remove';
import SettingsIcon from '@mui/icons-material/Settings';
import {
    Avatar, Box, Button, Container, Dialog, DialogActions, DialogContent,
    DialogContentText, DialogTitle, Divider, IconButton, List, ListItem, Alert,
    ListItemAvatar, ListItemText, MenuItem, Paper, Stack, TextField, Typography,
    Backdrop, CircularProgress
} from '@mui/material';
import MuiInput from '@mui/material/Input';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import React, { useState, useEffect } from 'react';
import { DataGenService } from './API/DataGenService';
import { developers, engFields, engTypes, fieldsAttributes, types } from './config/setup';

const App = () => {

    const theme = createTheme({
        typography: {
          subtitle1: {
              fontWeight: 500,
              color: "#95968F"
          },
          body1: {
              fontSize: 16
          },
          fontFamily: [
            'Inter',
            'Roboto',
            'Anonymous Pro'
          ].join(','),
        },
      });

    const [amount, setAmount] = useState(1);
    const [name, setName] = useState("");
    const [open, setOpen] = useState(false);
    const [isLoading, setIsLoading] = useState(false);
    
    const handleOpen = () => {setOpen(true);}
    const handleClose = () => {setOpen(false);}
    
    const [openDetails, setOpenDetails] = useState(false);

    const handleOpenDetails = () => {setOpenDetails(true);}
    const handleCloseDetails = () => {setOpenDetails(false);}


    const [inputFields, setInputFields] = useState([
        {name: "name", type: "name"},
        {name: "surname", type: "surname"},
        {name: "patronymic", type: "patronymic"},
    ])

    const [formErrors, setFormErrors] = useState("");
    const [openError, setOpenError] = useState(false);
    const handleOpenErrors = () => {setOpenError(true);}
    const handleCloseErrors = () => {
        setOpenError(false);
    }


    const [response, setResponse] = useState("");
    const [visible, setVisible] = useState(false);
    const [isSubmit, setIsSubmit] = useState(false);

    const handleChangeInput = (index, e) => {
        const values = [...inputFields];
        values[index][e.target.name] = e.target.value;
        setInputFields(values);
    }

    const handleChangeSelect = (index, e) => {
        const values = [...inputFields];
        let type = e.target.value;
        values[index] = {name: values[index].name, type: values[index].type};
        values[index][e.target.name] = type;

        // extra attributes
        values[index] = {...values[index], ...fieldsAttributes[type]};
        setInputFields(values);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        handleClose();
        validate(inputFields);
    }


    useEffect(() => {
        if (isSubmit) {
            setVisible(false);
            setResponse('');
            setIsLoading(true);
            let request = {name, amount, fields: inputFields};
            console.log("Generate!")
            console.log(request);
            console.log(JSON.stringify(request));
            DataGenService.sendRequest(request)
            .then((response) => response.json())
            .then((json) => {
                console.log(json);
                setResponse(JSON.stringify(json, undefined, 4));
                setIsLoading(false);
                setIsSubmit(false);
                setVisible(true);
            });
        }
    }, [isSubmit]);

    useEffect(() => {
        if (formErrors.length > 0) {
            handleOpenErrors();
        } else {
            setOpenError(false);
        }
    }, [formErrors])

    useEffect(() => {
        if (!openError) {
            setFormErrors('');
        }
    }, [openError])

    const validate = (fields) => {
        console.log('VALIDATE');
        let names = [];
        for (let i in fields) {
            let field = fields[i];
            if (field.name.length === 0) {
                setFormErrors('Именя полей не должны быть пустыми!')
                return;
            }
            else if (names.includes(field.name) ) {
                setFormErrors('Имена должны быть уникальными!')
                return;
            }
            else {
                names.push(field.name);
            }
        }
        console.log('VALIDATION SUCCESS');
        setIsSubmit(true);
    }

    const handleAddFields = () => {
        setInputFields([...inputFields, {name: "", type: ""}])
    }

    const handleRemoveFields = (index) => {
        const values = [...inputFields];
        values.splice(index, 1);
        setInputFields([...values]);
    }

    return (
        <ThemeProvider theme={theme}>
        <Container component={Paper} sx={{display: "flex", alignItems: "center", flexDirection: "column", p: 5,  backdropFilter: "blur(5px)"}}>
        <Button variant="text" size="large" 
                endIcon={<SettingsIcon/>} 
                 sx={{mb: 5}}
                 onClick={handleOpenDetails}
                 >
        DATAGEN
        </Button>
            <Dialog onClose={handleCloseDetails} open={openDetails}>
            <DialogTitle>Разработчики</DialogTitle>
            <List sx={{ pt: 0 }}>
                {developers.map((developer) => (
                <ListItem key={developer.name}>
                    <ListItemAvatar>
                    <Avatar src={`https://avatars.githubusercontent.com/${developer.name}`}/>
                    </ListItemAvatar>
                    <ListItemText primary={developer.name} secondary={developer.details}/>
                </ListItem>
                ))}
            </List>
            </Dialog>
            
            <Dialog onClose={handleCloseErrors} open={openError}>
                <DialogTitle>Ошибка!</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        <Alert severity="error">
                            {formErrors}
                        </Alert>
                    </DialogContentText>
                </DialogContent>
            </Dialog>
            
            <Box width="700px" component="form" onSubmit={handleSubmit} >
            <Dialog open={open} onClose={handleClose}
                    >
                <DialogTitle sx={{textAlign: "center"}}>Количество</DialogTitle>
                <DialogContent sx={{display: "flex", justifyContent: "center", alignItems: "center", flexDirection: "column"}}>
                <DialogContentText>
                    Укажите количество сущностей
                </DialogContentText>
                        <MuiInput
                            sx={{display: "flex", selfAlign: "center", width: "20%", mt: 1}}
                            onChange={(e) => setAmount(parseInt(e.target.value))}
                            value={amount}
                            size="small"
                            inputProps={{
                            step: 1,
                            min: 1,
                            max: 99999,
                            type: 'number',
                            }}
                        />
                </DialogContent>
                <DialogActions sx={{justifyContent: "center"}}>
                    <Button variant="contained"
                                    size="large" 
                                    endIcon={<PlayCircleFilledWhiteIcon/>} 
                                    onClick={handleSubmit}>
                                    Генерировать
                    </Button>
                </DialogActions>
            </Dialog>
            <TextField id="outlined-basic" name="name" 
            fullWidth label="Наименование cущности"
            sx={{mb: 1}} 
            variant="outlined" onChange={(e) => setName(e.target.value)}/>
                <Typography variant="subtitle1">Поля</Typography>
                <Divider sx={{mb: 2}}/>
                { inputFields.map((inputField, index) => (
                    <Stack key = {index} direction="row" sx={{mt: 2}}>
                        {Object.keys(inputField).map((key) => { return (
                                key === "type"
                                ?
                                <TextField sx={{mt: 1, mb: 1, mr: 1, flexGrow: 3}}
                                name={key}
                                select
                                value={inputField[key]} 
                                label={engFields[key]} onChange={e => handleChangeSelect(index, e)}
                                >
                                    {types.map((type, idx) => 
                                        <MenuItem key={idx} value={type}>
                                        {engTypes[type]}
                                        </MenuItem>)
                                    }
                                </TextField>
                                :
                                <TextField  variant="outlined"
                                sx={{mt: 1, mb: 1, mr: 1, flexGrow: 3}}
                                name={key} label={engFields[key]}
                                value={inputField[key]}
                                onChange={e => handleChangeInput(index, e)}
                                />
                         ) }
                        )}

                        <IconButton aria-label="delete"
                                    sx={{width: "40px", height: "100%", alignSelf: "center"}} 
                                    onClick={() => handleRemoveFields(index)}>
                        <RemoveIcon />
                        </IconButton>
                    </Stack>
                ))}


            <Stack  sx={{mt: 2, align: "center"}} direction="row" justifyContent="space-around">
                <Button  variant="outlined" 
                         endIcon={<AddCircleIcon/>} 
                         onClick={handleAddFields}
                         size="large"
                         >
                
                        Добавить
                </Button>
                {inputFields.length 
                ? <Button variant="contained"
                          size="large" 
                          endIcon={<PlayCircleFilledWhiteIcon/>} 
                          onClick={() => handleOpen()}>
                        Генерировать
                  </Button>
                : null
                }
            </Stack>
            { visible 
            ? 
            <Box>
            <Typography variant="subtitle1">Результат</Typography>
            <Divider sx={{mb: 2}}/>
            <TextField
                InputProps={{ style: { fontSize: 16, fontFamily: 'Anonymous Pro' }}}
                id="outlined-multiline-flexible"
                fullWidth
                multiline
                maxRows={10}
                value={response}
                />
            <Button onClick={() => setVisible(false)}>Очистить</Button>
            </Box>
            : null
            }
            </Box>
        </Container>
        <Backdrop
        sx={{ color: '#fff', zIndex: (theme) => theme.zIndex.drawer + 1 }}
        open={isLoading}
        >
        <CircularProgress color="inherit" />
        </Backdrop>
        </ThemeProvider>

    );
};

export default App;