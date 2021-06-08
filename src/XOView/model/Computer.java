package XOView.model;


public class Computer {

    public Point getShootPoint() {
        return Point.getRandomPoint();
    }

    public void computerShoot(Field field) {
        for (int i = 0; i < field.SIZE; i++) {
            for (int j = 0; j < field.SIZE; j++) {
                if (field.getCells()[i][j] == Field.Type.O) {

                    //                                    проверка на среднюю клетку


                    for (int s = i - 2; s < i + 3; s++) {
                        for (int q = j - 2; q < j + 5; q = q + 4) {

                            if (s < 0 || q < 0 || s > 2 || q > 2) {
                                continue;
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.O && field.getCells()[i][j - 1] == Field.Type.NONE) {
                                    field.setCells(i,j-1);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.O && field.getCells()[i][j + 1] == Field.Type.NONE) {
                                    field.setCells(i,j+1);;
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                    for (int s = i - 2; s < i + 5; s = s + 4) {
                        for (int q = j - 2; q < j + 3; q++) {
                            if (s < 0 || q < 0 || s > 2 || q > 2) {
                                continue;
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.O && field.getCells()[i - 1][j] == Field.Type.NONE) {
                                    field.setCells(i-1,j);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.O && field.getCells()[i + 1][j] == Field.Type.NONE) {
                                    field.setCells(i+1,j);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                    try {
                        if (field.getCells()[i + 2][j - 2] == Field.Type.O  && field.getCells()[i + 1][j - 1] == Field.Type.NONE) {
                            field.setCells(i+1,j-1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i - 2][j - 2] == Field.Type.O  && field.getCells()[i - 1][j - 1] == Field.Type.NONE) {
                            field.setCells(i-1,j-1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i - 2][j + 2] == Field.Type.O  && field.getCells()[i - 1][j + 1] ==Field.Type.NONE) {
                            field.setCells(i-1,j+1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i + 2][j + 2] == Field.Type.O  && field.getCells()[i + 1][j + 1] == Field.Type.NONE) {
                            field.setCells(i+1,j+1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }


//проверка по x
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (k < 0 || l < 0 || k > 2 || l > 2) {
                                continue;
                            }
                            if (k == i && l == j) {
                                continue;
                            }
                            if (field.getCells()[k][l] == Field.Type.O ) {
                                if (l == j) {
                                    try {
                                        if (field.getCells()[k + 1][l] == Field.Type.NONE) {
                                            if (field.getCells()[k + 1][l] != Field.Type.X && field.getCells()[k + 1][l] != Field.Type.O) {
                                                field.setCells(k+1,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k - 1][l] == Field.Type.NONE) {
                                            if (field.getCells()[k - 1][l] != Field.Type.X && field.getCells()[k - 1][l] != Field.Type.O) {
                                                field.setCells(k-1,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }

                                }
//проверка по y
                                if (k == i) {
                                    try {
                                        if (field.getCells()[k][l + 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l + 1] != Field.Type.X && field.getCells()[k][l + 1] != Field.Type.O) {
                                                field.setCells(k,l+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k][l - 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l - 1] != Field.Type.X && field.getCells()[k][l - 1] != Field.Type.O) {
                                                field.setCells(k,l-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                } else {
//                                    проверка по диагонали
                                    try {
                                        if (k == i - 1 && l == j - 1 && field.getCells()[i + 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[i + 1][j + 1] != Field.Type.X && field.getCells()[i + 1][j + 1] != Field.Type.O) {
                                                field.setCells(i+1,j+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j + 1 && field.getCells()[i - 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[i - 1][j - 1] != Field.Type.X && field.getCells()[i - 1][j - 1] != Field.Type.O) {
                                                field.setCells(i-1,j-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i - 1 && l == j + 1 && field.getCells()[i + 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[i + 1][j - 1] != Field.Type.X && field.getCells()[i + 1][j - 1] != Field.Type.O) {
                                                field.setCells(i+1,j-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j - 1 && field.getCells()[i - 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[i - 1][j + 1] != Field.Type.X && field.getCells()[i - 1][j + 1] != Field.Type.O) {
                                                field.setCells(i-1,j+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }


        //Препятствование игроку выиграть
        for (int i = 0; i < field.SIZE; i++) {
            for (int j = 0; j < field.SIZE; j++) {
                if (field.getCells()[i][j] == Field.Type.X) {
//                                    проверка на среднюю клетку
                    for (int s = i - 2; s < i + 3; s++) {
                        for (int q = j - 2; q < j + 5; q = q + 4) {
                            if (s < 0 || q < 0 || s > 2 || q > 2) {
                                continue;
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.X && field.getCells()[i][j - 1] == Field.Type.NONE) {
                                    field.setCells(i,j-1);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.X && field.getCells()[i][j + 1] == Field.Type.NONE) {
                                    field.setCells(i,j+1);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                    for (int s = i - 2; s < i + 5; s = s + 4) {
                        for (int q = j - 2; q < j + 3; q++) {
                            if (s < 0 || q < 0 || s > 2 || q > 2) {
                                continue;
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.X && field.getCells()[i - 1][j] == Field.Type.NONE) {
                                    field.setCells(i-1,j);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                            try {
                                if (field.getCells()[s][q] == Field.Type.X && field.getCells()[i + 1][j] == Field.Type.NONE) {
                                    field.setCells(i+1,j);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                    }
                    try {
                        if (field.getCells()[i + 2][j - 2] == Field.Type.X && field.getCells()[i + 1][j - 1] == Field.Type.NONE) {
                            field.setCells(i+1,j-1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i - 2][j - 2] == Field.Type.X && field.getCells()[i - 1][j - 1] == Field.Type.NONE) {
                            field.setCells(i-1,j-1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i - 2][j + 2] == Field.Type.X && field.getCells()[i - 1][j + 1] == Field.Type.NONE) {
                            field.setCells(i-1,j+1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    try {
                        if (field.getCells()[i + 2][j + 2] == Field.Type.X && field.getCells()[i + 1][j + 1] == Field.Type.NONE) {
                            field.setCells(i+1,j+1);
                            return;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }

//проверка по x
                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (k < 0 || l < 0 || k > 2 || l > 2) {
                                continue;
                            }
                            if (k == i && l == j) {
                                continue;
                            }
                            if (field.getCells()[k][l] == Field.Type.X) {
                                if (l == j) {

                                    try {
                                        if (field.getCells()[k + 1][l] == Field.Type.NONE) {
                                            if (field.getCells()[k + 1][l] != Field.Type.X && field.getCells()[k + 1][l] != Field.Type.O) {
                                                field.setCells(k+1,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k - 1][l] == Field.Type.NONE) {
                                            if (field.getCells()[k - 1][l] != Field.Type.X && field.getCells()[k - 1][l] != Field.Type.O) {
                                                field.setCells(k-1,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }

                                }
//проверка по y
                                if (k == i) {
                                    try {
                                        if (field.getCells()[k][l + 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l + 1] != Field.Type.X && field.getCells()[k][l + 1] != Field.Type.O) {
                                                field.setCells(k,l+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k][l - 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l - 1] != Field.Type.X && field.getCells()[k][l - 1] != Field.Type.O) {
                                                field.setCells(k,l-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                } else {
                                    //проверка по диагонали
                                    try {
                                        if (k == i - 1 && l == j - 1 && field.getCells()[i + 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[i + 1][j + 1] != Field.Type.X && field.getCells()[i + 1][j + 1] != Field.Type.O) {
                                                field.setCells(i+1,j+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j + 1 && field.getCells()[i - 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[i - 1][j - 1] != Field.Type.X && field.getCells()[i - 1][j - 1] != Field.Type.O) {
                                                field.setCells(i-1,j-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i - 1 && l == j + 1 && field.getCells()[i + 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[i + 1][j - 1] != Field.Type.X && field.getCells()[i + 1][j - 1] != Field.Type.O) {
                                                field.setCells(i+1,j-1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j - 1 && field.getCells()[i - 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[i - 1][j + 1] != Field.Type.X && field.getCells()[i - 1][j + 1] != Field.Type.O) {
                                                field.setCells(i-1,j+1);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


//        Проверка соседней клетки

        for (int i = 0; i < field.SIZE; i++) {
            for (int j = 0; j < field.SIZE; j++) {
                if (field.getCells()[i][j] == Field.Type.O ) {

                    for (int k = i - 1; k < i + 2; k++) {
                        for (int l = j - 1; l < j + 2; l++) {
                            if (k < 0 || l < 0 || k > 2 || l > 2) {
                                continue;
                            }
                            if (k == i && l == j) {
                                continue;
                            }
                            if (field.getCells()[k][l] == Field.Type.NONE) {
                                if (l == j) {
                                    try {
                                        if (field.getCells()[k + 1][l] ==Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k - 1][l] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }

                                }

                                if (k == i) {
                                    try {
                                        if (field.getCells()[k][l + 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (field.getCells()[k][l - 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                } else {
                                    try {
                                        if (k == i - 1 && l == j - 1 && field.getCells()[i + 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j + 1 && field.getCells()[i - 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i - 1 && l == j + 1 && field.getCells()[i + 1][j - 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                    try {
                                        if (k == i + 1 && l == j - 1 && field.getCells()[i - 1][j + 1] == Field.Type.NONE) {
                                            if (field.getCells()[k][l] != Field.Type.X && field.getCells()[k][l] != Field.Type.O) {
                                                field.setCells(k,l);
                                                return;
                                            }
                                        }
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        while (true) {
            int X = getShootPoint().getX();
            int Y = getShootPoint().getY();
            if (field.getCells()[X][Y] != Field.Type.X && field.getCells()[X][Y] != Field.Type.O) {
                field.setCells(X,Y);
                return;
            }
        }
    }
}
