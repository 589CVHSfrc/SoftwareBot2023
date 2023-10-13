// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private CANSparkMax m_rightMotor; 
  private CANSparkMax m_leftMotor; 
  private RelativeEncoder m_rightEncoder; 
  private RelativeEncoder m_leftEncoder;

  private DifferentialDrive m_drive;

  public DriveSubsystem() {
    m_rightMotor = new CANSparkMax(12, MotorType.kBrushless);
    m_leftMotor = new CANSparkMax(11, MotorType.kBrushless);
    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    m_rightEncoder=m_rightMotor.getEncoder();
    m_leftEncoder=m_leftMotor.getEncoder();
    m_rightEncoder.setPositionConversionFactor(Math.PI*2*3/8.45);
    m_leftEncoder.setPositionConversionFactor(Math.PI*2*3/8.45);

  }
  public void driveDistance(double Inches){
    
  }
  public void tankDrive(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    m_drive.tankDrive(leftSpeed.getAsDouble()*.5, rightSpeed.getAsDouble()*.5);

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
