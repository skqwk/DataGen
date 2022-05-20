import React from 'react';
import { Typography, Stack } from '@mui/material';

const Header = () => {

    const style = {minWidth: "45%"};

    return (
        <Stack direction="row" justifyContent="space-between" width="100%">
                <Typography sx={style}>
                    Название
                </Typography>
                <Typography sx={style}>
                    Тип
                </Typography>
        </Stack>
    );
};

export default Header;