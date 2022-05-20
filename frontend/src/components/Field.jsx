import { MenuItem, Select, Stack, TextField, IconButton } from '@mui/material';
import React, { useState, useEffect } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';


const Field = ({idx, fields, setFields, deleteField, inputs, setInputs}) => {

    const style = {minWidth: "45%"};

    const [type, setType] = useState("");
    const [field, setField] = useState({})

    const types = [
        "String",
        "Num"
    ];


    useEffect(() => {
        fields[idx] = field;
        setFields(fields);
    }, [field])

    const fillText = (e) => {
        setField({...field, name: e.target.value})
    }
    
    const selectChange = (e) => {
        setField({...field, type: e.target.value})
        setType(e.target.value);
    };

    const remove = () => {
        deleteField(idx);
        // console.log("Try remove");
        // console.log(inputs);
        // let filteredInputs = inputs.filter(input => input.props.idx != idx);
        // console.log(filteredInputs);


        // delete fields[idx];
        // setFields(fields);
        // setInputs(inputs);
    }


    return (
        <Stack sx={{mt: 2}} direction="row" justifyContent="space-between" width="100%">
            <TextField  variant="outlined" sx={style} onChange={fillText}/>
            <Select
                sx={style}
                autoWidth
                value={type}
                label="type"
                onChange={selectChange}
            >
                {types.map((type, idx) => 
                    <MenuItem key={idx} value={type}>
                    {type}
                    </MenuItem>)
                }
            </Select>
            <IconButton aria-label="delete" onClick={remove}>
            <DeleteIcon />
            </IconButton>
        </Stack>
    );
};

export default Field;